package app.ccb.domain.dtos.xml.cards;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "card")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportCardDto {

    @XmlElement(name = "card-number")
    private String cardNumber;

    @XmlAttribute(name = "status")
    private String cardStatus;
    @XmlAttribute(name = "account-number")
    private String accountNumber;

    public ImportCardDto() {
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
