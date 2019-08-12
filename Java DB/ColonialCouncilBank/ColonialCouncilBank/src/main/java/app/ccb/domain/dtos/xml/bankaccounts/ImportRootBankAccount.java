package app.ccb.domain.dtos.xml.bankaccounts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "bank-accounts")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportRootBankAccount {

    @XmlElement(name = "bank-account")
    private List<ImportBankAccount> importBankAccounts;

    public ImportRootBankAccount() {
    }

    public List<ImportBankAccount> getImportBankAccounts() {
        return importBankAccounts;
    }

    public void setImportBankAccounts(List<ImportBankAccount> importBankAccounts) {
        this.importBankAccounts = importBankAccounts;
    }
}
