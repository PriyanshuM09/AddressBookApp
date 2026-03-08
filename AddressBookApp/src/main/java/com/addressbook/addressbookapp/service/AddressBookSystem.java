package com.addressbook.addressbookapp.service;

import java.util.HashMap;
import java.util.Map;

public class AddressBookSystem {

    private Map<String, AddressBook> addressBooks = new HashMap<>();

    // Add new Address Book
    public void addAddressBook(String name) {

        if (addressBooks.containsKey(name)) {
            System.out.println("Address Book already exists.");
            return;
        }

        addressBooks.put(name, new AddressBook());
        System.out.println("Address Book '" + name + "' created successfully.");
    }

    // Get AddressBook
    public AddressBook getAddressBook(String name) {
        return addressBooks.get(name);
    }

    // Display all address books
    public void displayAddressBooks() {

        if (addressBooks.isEmpty()) {
            System.out.println("No Address Books available.");
            return;
        }

        System.out.println("Available Address Books:");

        for (String name : addressBooks.keySet()) {
            System.out.println(name);
        }
    }
}