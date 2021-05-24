package com.magomed.tutorial;

public class Withdraw extends Balance {
    private int amountToWithdraw;

    public Withdraw() {}

    public int getAmountToWithdraw() {
        return amountToWithdraw;
    }

    public void setAmountToWithdraw(Balance balance, int amountToWithdraw) {
        balance.setBalance(-amountToWithdraw);
    }
}
