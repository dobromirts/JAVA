package app.ccb.services;

import app.ccb.domain.dtos.xml.bankaccounts.ImportRootBankAccount;
import app.ccb.domain.dtos.xml.cards.ImportCardDto;
import app.ccb.domain.dtos.xml.cards.ImportRootCardDto;
import app.ccb.domain.entities.BankAccount;
import app.ccb.domain.entities.Card;
import app.ccb.repositories.BankAccountRepository;
import app.ccb.repositories.CardRepository;
import app.ccb.util.FileUtil;
import app.ccb.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

@Service
public class CardServiceImpl implements CardService {
    private static final String XML_CARD_PATH = "D:\\JavaDB Advanced-Hibernate,Spring\\ColonialCouncilBank\\ColonialCouncilBank\\src\\main\\resources\\files\\xml\\cards.xml";

    private final CardRepository cardRepository;
    private final FileUtil fileUtil;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final BankAccountRepository bankAccountRepository;

    public CardServiceImpl(CardRepository cardRepository, FileUtil fileUtil, ModelMapper modelMapper, ValidationUtil validationUtil, BankAccountRepository bankAccountRepository) {
        this.cardRepository = cardRepository;
        this.fileUtil = fileUtil;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public Boolean cardsAreImported() {
        return this.cardRepository.count() != 0;
    }

    @Override
    public String readCardsXmlFile() throws IOException {
        return this.fileUtil.readFile(XML_CARD_PATH);
    }

    @Override
    public String importCards() throws JAXBException {
        StringBuilder sb=new StringBuilder();
        JAXBContext context=JAXBContext.newInstance(ImportRootCardDto.class);
        Unmarshaller unmarshaller=context.createUnmarshaller();
        ImportRootCardDto importRootCardDto= (ImportRootCardDto) unmarshaller.unmarshal(new File((XML_CARD_PATH)));

        for (ImportCardDto cardDto : importRootCardDto.getCardDtos()) {
            Card card=this.modelMapper.map(cardDto,Card.class);
            BankAccount bankAccount=this.bankAccountRepository.findByAccountNumber(cardDto.getAccountNumber());

            if (bankAccount==null || !this.validationUtil.isValid(card)){
                sb.append("Error: Incorrect Data!").append(System.lineSeparator());
                continue;
            }

            card.setBankAccount(bankAccount);
            this.cardRepository.saveAndFlush(card);
            sb.append(String.format("Successfully imported Card –%s.",card.getCardNumber())).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
