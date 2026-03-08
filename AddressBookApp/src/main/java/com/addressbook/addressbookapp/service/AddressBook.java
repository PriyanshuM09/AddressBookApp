package com.addressbook.addressbookapp.service;

import com.addressbook.addressbookapp.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

    private List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added successfully!");
    }

    public void displayContacts() {
        contacts.forEach(System.out::println);
    }
}