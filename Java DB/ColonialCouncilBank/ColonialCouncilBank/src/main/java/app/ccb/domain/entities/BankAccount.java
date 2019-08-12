package app.ccb.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "bank_accounts")
public class BankAccount extends BaseEntity{
    private String accountNumber;
    private BigDecimal balance;
    private Client client;
    private List<Card> cards;


    public BankAccount() {
    }

    @NotNull
    @Column(name = "account_number",nullable = false)
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @NotNull
    @Column(name = "balance",nullable = false)
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @OneToOne(targetEntity = Client.class)
    @JoinColumn(name = "client_id",referencedColumnName = "id")
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @OneToMany(mappedBy = "bankAccount",cascade = CascadeType.ALL,targetEntity = Card.class)
    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
