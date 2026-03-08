package com.addressbook.addressbookapp.service;

import com.addressbook.addressbookapp.model.Contact;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

    private List<Contact> contacts = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    // UC2 → Add Contact
    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added successfully!");
    }

    // UC2 → Display Contacts
    public void displayContacts() {

        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    // UC3 → Edit Contact
    public void editContact(String firstName) {

        for (Contact contact : contacts) {

            if (contact.getFirstName().equalsIgnoreCase(firstName)) {

                System.out.println("Enter new Last Name:");
                contact.setLastName(scanner.nextLine());

                System.out.println("Enter new Address:");
                contact.setAddress(scanner.nextLine());

                System.out.println("Enter new City:");
                contact.setCity(scanner.nextLine());

                System.out.println("Enter new State:");
                contact.setState(scanner.nextLine());

                System.out.println("Enter new Zip:");
                contact.setZip(scanner.nextLine());

                System.out.println("Enter new Phone Number:");
                contact.setPhoneNumber(scanner.nextLine());

                System.out.println("Enter new Email:");
                contact.setEmail(scanner.nextLine());

                System.out.println("Contact updated successfully!");
                return;
            }
        }

        System.out.println("Contact not found.");
    }
}