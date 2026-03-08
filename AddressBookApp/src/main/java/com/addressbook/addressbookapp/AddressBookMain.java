package com.addressbook.addressbookapp;

import java.util.Scanner;

import com.addressbook.addressbookapp.service.AddressBook;
import com.addressbook.addressbookapp.service.AddressBookSystem;

public class AddressBookMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AddressBookSystem system = new AddressBookSystem();

        while (true) {

            System.out.println("\n===== Address Book System =====");
            System.out.println("1. Create Address Book");
            System.out.println("2. Select Address Book");
            System.out.println("3. Show Address Books");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Address Book name: ");
                    String name = scanner.nextLine();

                    system.addAddressBook(name);
                    break;

                case 2:

                    System.out.print("Enter Address Book name: ");
                    String bookName = scanner.nextLine();

                    AddressBook book = system.getAddressBook(bookName);

                    if (book == null) {
                        System.out.println("Address Book not found.");
                        break;
                    }

                    book.displayContacts();
                    break;

                case 3:
                    system.displayAddressBooks();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
            }
        }
    }
}