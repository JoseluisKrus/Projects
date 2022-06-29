package BankingApp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to All Citizens Bank.");
        System.out.println("Please enter your Name and CustomerId to access your bank account:");
        String name = scanner.nextLine();
        String customerId = scanner.nextLine();

        BankAccount bankAccount = new BankAccount(name, customerId);
        bankAccount.menu();


    }
}
