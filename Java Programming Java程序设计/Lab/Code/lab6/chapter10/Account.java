package lab6.chapter10;
// 10.7

import java.util.Date;

public class Account {
    private int id;
    private double balance;
    // Note: annualInterestRate is a percentage
    private static double annualInterestRate = 0;
    private final Date dateCreated;

    Account() {
        this.id = 0;
        this.balance = 0;
        this.dateCreated = new Date();
    }

    Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.dateCreated = new Date();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate / 100;
    }

    public static void setAnnualInterestRate(double newAnnualInterestRate) {
        annualInterestRate = newAnnualInterestRate;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    public static double getMonthlyInterestRate() {
        return annualInterestRate / 100 / 12;
    }

    public double getMonthlyInterest() {
        return this.balance * getMonthlyInterestRate();
    }

    public boolean withdraw(double withdrawBalance) {
        if (this.balance - withdrawBalance >= 0) {
            this.balance -= withdrawBalance;
            return true;
        } else {
            return false;
        }
    }

    public double deposit(double depositBalance){
        this.balance += depositBalance;
        return this.balance;
    }
}
