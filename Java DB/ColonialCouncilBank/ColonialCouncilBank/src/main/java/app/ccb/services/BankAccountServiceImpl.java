package app.ccb.services;

import app.ccb.domain.dtos.xml.bankaccounts.ImportBankAccount;
import app.ccb.domain.dtos.xml.bankaccounts.ImportRootBankAccount;
import app.ccb.domain.entities.BankAccount;
import app.ccb.domain.entities.Client;
import app.ccb.repositories.BankAccountRepository;
import app.ccb.repositories.ClientRepository;
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
public class BankAccountServiceImpl implements BankAccountService {
    private static final String XML_BANK_ACOOUNT_PATH="D:\\JavaDB Advanced-Hibernate,Spring\\ColonialCouncilBank\\ColonialCouncilBank\\src\\main\\resources\\files\\xml\\bank-accounts.xml";

    private final BankAccountRepository bankAccountRepository;
    private final FileUtil fileUtil;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final ClientRepository clientRepository;

    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository, FileUtil fileUtil, ModelMapper modelMapper, ValidationUtil validationUtil, ClientRepository clientRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.fileUtil = fileUtil;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.clientRepository = clientRepository;
    }


    @Override
    public Boolean bankAccountsAreImported() {
        return this.bankAccountRepository.count() != 0;
    }

    @Override
    public String readBankAccountsXmlFile() throws IOException {
        return this.fileUtil.readFile(XML_BANK_ACOOUNT_PATH);
    }

    @Override
    public String importBankAccounts() throws JAXBException {
        StringBuilder sb=new StringBuilder();
        JAXBContext context=JAXBContext.newInstance(ImportRootBankAccount.class);
        Unmarshaller unmarshaller=context.createUnmarshaller();
        ImportRootBankAccount importRootBankAccount= (ImportRootBankAccount) unmarshaller.unmarshal(new File((XML_BANK_ACOOUNT_PATH)));

        for (ImportBankAccount importBankAccount : importRootBankAccount.getImportBankAccounts()) {
            BankAccount bankAccount=this.modelMapper.map(importBankAccount,BankAccount.class);
            Client client=this.clientRepository.findDistinctFirstByFullName(importBankAccount.getClientName());

            System.out.println();

            if (client==null || !this.validationUtil.isValid(bankAccount)){
                sb.append("Error: Incorrect Data!").append(System.lineSeparator());
                continue;
            }



            bankAccount.setClient(client);
            this.bankAccountRepository.saveAndFlush(bankAccount);
            sb.append(String.format("Successfully imported Bank Account –%s.",bankAccount.getAccountNumber())).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
