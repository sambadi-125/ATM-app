package com.magomed.tutorial;

public class Balance {
    private int balance;

    public Balance() {}

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance += balance;
    }

    public String showBalance() {
        return "\n\tYOUR BALANCE IS " + this.balance + " EUR.\t";
    }
}
