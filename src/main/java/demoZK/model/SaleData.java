package demoZK.model;

import java.io.Serializable;

/**
 * Created by Admin on 23.05.2017.
 */
public class SaleData implements Serializable{

    private String accountNumber; //cardNum
    private String acountAccessory;//expDate
    private String csc;
    private Integer amount;
    private String holderName;  //cardHolder
    private String Street;
    private String City;
    private String  State;
    private String ZipCode;

    public SaleData() {
    }

    public SaleData(String accountNumber, String acountAccessory, String csc, Integer amount, String holderName, String street, String city, String state, String zipCode) {
        this.accountNumber = accountNumber;
        this.acountAccessory = acountAccessory;
        this.csc = csc;
        this.amount = amount;
        this.holderName = holderName;
        Street = street;
        City = city;
        State = state;
        ZipCode = zipCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAcountAccessory() {
        return acountAccessory;
    }

    public void setAcountAccessory(String acountAccessory) {
        this.acountAccessory = acountAccessory;
    }

    public String getCsc() {
        return csc;
    }

    public void setCsc(String csc) {
        this.csc = csc;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getZipCode() {
        return ZipCode;
    }

    public void setZipCode(String zipCode) {
        ZipCode = zipCode;
    }
}
