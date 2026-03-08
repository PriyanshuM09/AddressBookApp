package com.addressbook.addressbookapp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.addressbook.addressbookapp.model.Contact;

public class AddressBookSystem {

    private Map<String, AddressBook> addressBooks = new HashMap<>();

    // UC6 → Add new Address Book
    public void addAddressBook(String name) {

        if (addressBooks.containsKey(name)) {
            System.out.println("Address Book already exists.");
            return;
        }

        addressBooks.put(name, new AddressBook());
        System.out.println("Address Book '" + name + "' created successfully.");
    }

    // UC6 → Get AddressBook
    public AddressBook getAddressBook(String name) {
        return addressBooks.get(name);
    }

    // UC8 → Search Person by City across all AddressBooks
    public List<Contact> searchByCity(String city) {

        List<Contact> result = new ArrayList<>();

        for (AddressBook book : addressBooks.values()) {

            book.getContacts()
                .stream()
                .filter(contact -> contact.getCity().equalsIgnoreCase(city))
                .forEach(result::add);
        }

        return result;
    }

    // UC8 → Search Person by State across all AddressBooks
    public List<Contact> searchByState(String state) {

        List<Contact> result = new ArrayList<>();

        for (AddressBook book : addressBooks.values()) {

            book.getContacts()
                .stream()
                .filter(contact -> contact.getState().equalsIgnoreCase(state))
                .forEach(result::add);
        }

        return result;
    }

    // Display all AddressBooks
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