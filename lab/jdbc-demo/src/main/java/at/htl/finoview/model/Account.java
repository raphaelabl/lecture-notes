package at.htl.finoview.model;

public class Account {
    
    private String iban;
    private String holder;
    private String swift;
    private Long accountNo;
    private Long bankCode;

    //region constructors
    public Account() {
    }

    public Account(String iban) {
        this.iban = iban;
    }
    //endregion

    //region getter and setter
    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

    public Long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }

    public Long getBankCode() {
        return bankCode;
    }

    public void setBankCode(Long bankCode) {
        this.bankCode = bankCode;
    }
    //endregion


    @Override
    public String toString() {
        return iban;
    }
}
