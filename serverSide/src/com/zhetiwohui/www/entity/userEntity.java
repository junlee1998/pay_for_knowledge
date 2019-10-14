package com.zhetiwohui.www.entity;

public class userEntity {

    private String username;
    private String password;
    private String gender;
    private String tel;
    private String emailAddress;
    private String transactionPassword;
    private String health;
    private int balance;

    public userEntity() {
    }

    public userEntity(String username, String password, String gender, String tel, String emailAddress, String transactionPassword, String health, int balance) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.tel = tel;
        this.emailAddress = emailAddress;
        this.transactionPassword = transactionPassword;
        this.health = health;
        this.balance = balance;
    }

    public userEntity(String username, String password, String gender, String tel, String emailAddress, String transactionPassword) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.tel = tel;
        this.emailAddress = emailAddress;
        this.transactionPassword = transactionPassword;
        this.balance=0;
        this.health="0";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getTransactionPassword() {
        return transactionPassword;
    }

    public void setTransactionPassword(String transactionPassword) {
        this.transactionPassword = transactionPassword;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "userEntity{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", tel='" + tel + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", transactionPassword='" + transactionPassword + '\'' +
                ", health='" + health + '\'' +
                ", balance=" + balance +
                '}';
    }
}

