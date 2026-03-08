package com.addressbook.addressbookapp.service;

import com.addressbook.addressbookapp.model.Contact;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

    private List<Contact> contacts = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public void addContact(Contact contact) {

        boolean duplicate = contacts.stream()
                .anyMatch(c -> c.getFirstName()
                .equalsIgnoreCase(contact.getFirstName()));

        if (duplicate) {
            System.out.println("Duplicate contact not allowed.");
            return;
        }

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
    public List<Contact> sortContactsByName() {

        return contacts.stream()
                .sorted((c1, c2) -> 
                    c1.getFirstName().compareToIgnoreCase(c2.getFirstName()))
                .toList();
    }

    // UC4 → Delete Contact
    public void deleteContact(String firstName) {

        for (Contact contact : contacts) {

            if (contact.getFirstName().equalsIgnoreCase(firstName)) {
            	contacts.removeIf(c -> c.getFirstName().equalsIgnoreCase(firstName));
                System.out.println("Contact deleted successfully!");
                return;
            }
        }

        System.out.println("Contact not found.");
    }

    // Needed for JUnit Testing
    public List<Contact> getContacts() {
        return contacts;
    }
}