package BankingApp;

import java.util.Scanner;

public class BankAccount {
    private double balance;
    private String customerName;
    private String customerId;

    public BankAccount(String name, String customerId) {
        this.customerName = name;
        this.customerId = customerId;
    }

    void deposit(double amount) {
        if(amount > 0) {
            this.balance += amount;
            System.out.println("You have successfully deposited: " + amount + "$");
        }else {
            System.out.println("Enter a positive number!!!");
        }
    }

    void withdraw(double amount) {
        if( amount <= 0){
            System.out.println("Please enter positive number!!!");
        }
        else if (balance >= amount) {
            this.balance -= amount;
            System.out.println("You have successfully withdrew: " + amount + "$");
        }else {
            System.out.println("Bank balance insufficient");
        }
    }

    void menu() {
        char option;

        System.out.println("Welcome, " + customerName);
        System.out.println("Your ID: " + customerId);
        System.out.println();
        System.out.println("a) Check Balance");
        System.out.println("b) Deposit Amount");
        System.out.println("c) Withdraw Amount");
        System.out.println("d) Exit");
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("----------------------------");
            System.out.println("Choose an option");
            option = scanner.next().charAt(0);

            switch (option) {
                case 'a':
                    System.out.println("Your balance is: " + balance + "$");
                    break;
                case 'b':
                    System.out.println("Enter the amount to deposit:");
                    double amount = scanner.nextDouble();
                    deposit(amount);
                    break;
                case 'c':
                    System.out.println("Enter the amount to withdraw:");
                    amount = scanner.nextDouble();
                    withdraw(amount);
                    break;
            }

        } while (option != 'd');

        System.out.println("Thank you for using our banking services");
    }
}
