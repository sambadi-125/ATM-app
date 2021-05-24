package com.magomed.tutorial;

import com.magomed.tutorial.Deposit;
import com.magomed.tutorial.Balance;
import com.magomed.tutorial.Withdraw;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Character.isDigit;


public class Main {

	// Repeating text put in function to keep it DRY:
	public static void options () {
		System.out.println("\n\t1. Check balance\n" +
				"\t2. Deposit\n" +
				"\t3. Withdraw\n" +
				"\t0. Exit\n");
	}

	// Objects initialization (setup):
    public static void main(String[] args) {
	Withdraw withdraw = new Withdraw();
	Balance balance = new Balance();
	Deposit deposit = new Deposit();
	Scanner scanner = new Scanner(System.in);
	int selection = 5;

	// Main body:
	System.out.print("\n\tWelcome to ATM\n"); // Welcome text that only needs to appear once!1
	while (selection != 0) {

		options();

		System.out.print("\tSelect the option: ");
		try {
			selection = scanner.nextInt();
			switch (selection) {

				case 1:
					System.out.println(balance.showBalance());
					break;

				case 2:
					int enteredAmount = 0;
					System.out.print("\n\tEnter the amount you would like to deposit: ");
					while(true) {
						try {
							enteredAmount = scanner.nextInt();
							balance.setBalance(enteredAmount);
							System.out.println("\n\tYOU DEPOSITED " + enteredAmount + " EUR." + balance.showBalance());
							break;
						} catch (InputMismatchException e) {
							System.out.print("\n\tInvalid input. Must be an integer. Please reenter: ");
							scanner.nextLine();
						}
					}
					break;
				case 3:
					System.out.print("\n\tEnter the amount you would like to withdraw: ");
					while(true) {
						try{
						enteredAmount = scanner.nextInt();
						while (balance.getBalance() < enteredAmount) {
							System.out.println("\n\tYou cannot exceed your balance. Your balance is " + balance.getBalance());
							System.out.print("\n\tEnter the amount you would like to deposit or enter 0 to return to main screen: ");
							enteredAmount = scanner.nextInt();
							if (enteredAmount == 0){
								break;
							}
						}
						balance.setBalance(-enteredAmount);
						System.out.println("\n\tYOU WITHDREW " + enteredAmount + " EUR." + balance.showBalance());
						break;
						} catch (InputMismatchException e) {
							System.out.print("\n\tInvalid input. Must be an integer. Please reenter: ");
							scanner.nextLine();
						}
					}
					break;
				case 0:
					System.out.println("\n\tTHANK YOU FOR VISITING!\n\t");
					break;

				default:
					System.out.println("\n\tWrong selection. Try again!\n\t");

			}
		}
		catch (InputMismatchException e) {
			System.out.print("\n\tInvalid input. Please reenter. \n");
			scanner.nextLine();
		}

	}
	scanner.close();
    }
}
