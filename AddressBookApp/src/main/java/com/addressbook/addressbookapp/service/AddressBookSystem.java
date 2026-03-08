package com.addressbook.addressbookapp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.addressbook.addressbookapp.model.Contact;

public class AddressBookSystem {

    private Map<String, AddressBook> addressBooks = new HashMap<>();

    private Map<String, List<Contact>> cityDictionary = new HashMap<>();
    private Map<String, List<Contact>> stateDictionary = new HashMap<>();

    // UC6 → Add AddressBook
    public void addAddressBook(String name) {

        if (addressBooks.containsKey(name)) {
            System.out.println("Address Book already exists.");
            return;
        }

        addressBooks.put(name, new AddressBook());
        System.out.println("Address Book '" + name + "' created successfully.");
    }

    public AddressBook getAddressBook(String name) {
        return addressBooks.get(name);
    }

    // UC8 → Search by City
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

    // UC8 → Search by State
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

    // UC9 → Add contact to city/state dictionary
    public void addToDictionary(Contact contact) {

        cityDictionary
            .computeIfAbsent(contact.getCity(), k -> new ArrayList<>())
            .add(contact);

        stateDictionary
            .computeIfAbsent(contact.getState(), k -> new ArrayList<>())
            .add(contact);
    }

    // UC9 → View persons by city
    public void viewPersonsByCity(String city) {

        List<Contact> list = cityDictionary.get(city);

        if (list == null || list.isEmpty()) {
            System.out.println("No contacts found in city: " + city);
            return;
        }

        System.out.println("Contacts in city: " + city);

        list.forEach(System.out::println);
    }

    // UC9 → View persons by state
    public void viewPersonsByState(String state) {

        List<Contact> list = stateDictionary.get(state);

        if (list == null || list.isEmpty()) {
            System.out.println("No contacts found in state: " + state);
            return;
        }

        System.out.println("Contacts in state: " + state);

        list.forEach(System.out::println);
    }
    public Map<String, Long> countByCity() {

        Map<String, Long> cityCount = new HashMap<>();

        for (AddressBook book : addressBooks.values()) {

            book.getContacts()
                .stream()
                .forEach(contact -> cityCount.merge(
                        contact.getCity(), 
                        1L, 
                        Long::sum));
        }

        return cityCount;
    }

    public Map<String, Long> countByState() {

        Map<String, Long> stateCount = new HashMap<>();

        for (AddressBook book : addressBooks.values()) {

            book.getContacts()
                .stream()
                .forEach(contact -> stateCount.merge(
                        contact.getState(), 
                        1L, 
                        Long::sum));
        }

        return stateCount;
    }
    // Display AddressBooks
    public void displayAddressBooks() {

        if (addressBooks.isEmpty()) {
            System.out.println("No Address Books available.");
            return;
        }

        System.out.println("Available Address Books:");

        addressBooks.keySet().forEach(System.out::println);
    }
}