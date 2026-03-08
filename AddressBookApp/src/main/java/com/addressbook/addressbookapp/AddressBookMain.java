package com.addressbook.addressbookapp;

import com.addressbook.addressbookapp.model.Contact;
import com.addressbook.addressbookapp.service.AddressBook;
import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {

        System.out.println("Welcome to Address Book");

        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        // Create Contact (UC2)
        System.out.println("Enter First Name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter Last Name:");
        String lastName = scanner.nextLine();

        System.out.println("Enter Address:");
        String address = scanner.nextLine();

        System.out.println("Enter City:");
        String city = scanner.nextLine();

        System.out.println("Enter State:");
        String state = scanner.nextLine();

        System.out.println("Enter Zip:");
        String zip = scanner.nextLine();

        System.out.println("Enter Phone Number:");
        String phone = scanner.nextLine();

        System.out.println("Enter Email:");
        String email = scanner.nextLine();

        Contact contact = new Contact(
                firstName,
                lastName,
                address,
                city,
                state,
                zip,
                phone,
                email
        );

        addressBook.addContact(contact);

        System.out.println("\nContacts List:");
        addressBook.displayContacts();

        // UC3 → Edit Contact
        System.out.println("\nEnter first name of contact to edit:");
        String nameToEdit = scanner.nextLine();

        addressBook.editContact(nameToEdit);

        System.out.println("\nUpdated Contacts:");
        addressBook.displayContacts();
    }
}