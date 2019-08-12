package app.ccb.domain.dtos.xml.cards;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cards")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportRootCardDto {
    @XmlElement(name = "card")
    private List<ImportCardDto> cardDtos;

    public ImportRootCardDto() {
    }

    public List<ImportCardDto> getCardDtos() {
        return cardDtos;
    }

    public void setCardDtos(List<ImportCardDto> cardDtos) {
        this.cardDtos = cardDtos;
    }
}
