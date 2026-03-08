package com.addressbook.addressbookapp.service;

import com.addressbook.addressbookapp.model.Contact;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

    private List<Contact> contacts = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    // UC2 → Add Contact (with duplicate check UC7)
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
    public void writeContactsToFile(String filePath) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            for (Contact contact : contacts) {

                writer.write(contact.getFirstName() + " "
                        + contact.getLastName() + " "
                        + contact.getAddress() + " "
                        + contact.getCity() + " "
                        + contact.getState() + " "
                        + contact.getZip() + " "
                        + contact.getPhoneNumber() + " "
                        + contact.getEmail());

                writer.newLine();
            }

            System.out.println("Contacts written to file successfully.");

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
    public void readContactsFromFile(String filePath) {

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    public void writeContactsToCSV(String filePath) {

        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {

            String[] header = {
                    "FirstName","LastName","Address",
                    "City","State","Zip","Phone","Email"
            };

            writer.writeNext(header);

            for (Contact contact : contacts) {

                String[] data = {
                        contact.getFirstName(),
                        contact.getLastName(),
                        contact.getAddress(),
                        contact.getCity(),
                        contact.getState(),
                        contact.getZip(),
                        contact.getPhoneNumber(),
                        contact.getEmail()
                };

                writer.writeNext(data);
            }

            System.out.println("Contacts written to CSV successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readContactsFromCSV(String filePath) {

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {

            String[] line;

            while ((line = reader.readNext()) != null) {

                for (String value : line) {
                    System.out.print(value + " ");
                }

                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
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

    // UC4 → Delete Contact
    public void deleteContact(String firstName) {

        boolean removed = contacts.removeIf(contact ->
                contact.getFirstName().equalsIgnoreCase(firstName));

        if (removed) {
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Contact not found.");
        }
    }

    // UC11 → Sort by Name
    public List<Contact> sortContactsByName() {

        return contacts.stream()
                .sorted((c1, c2) ->
                        c1.getFirstName().compareToIgnoreCase(c2.getFirstName()))
                .toList();
    }

    // UC12 → Sort by City
    public List<Contact> sortByCity() {

        return contacts.stream()
                .sorted((c1, c2) ->
                        c1.getCity().compareToIgnoreCase(c2.getCity()))
                .toList();
    }

    // UC12 → Sort by State
    public List<Contact> sortByState() {

        return contacts.stream()
                .sorted((c1, c2) ->
                        c1.getState().compareToIgnoreCase(c2.getState()))
                .toList();
    }

    // UC12 → Sort by Zip
    public List<Contact> sortByZip() {

        return contacts.stream()
                .sorted((c1, c2) ->
                        c1.getZip().compareToIgnoreCase(c2.getZip()))
                .toList();
    }

    // Getter for JUnit Testing
    public List<Contact> getContacts() {
        return contacts;
    }
}