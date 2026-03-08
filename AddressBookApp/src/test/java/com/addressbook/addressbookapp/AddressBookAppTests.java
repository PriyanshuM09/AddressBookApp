package com.addressbook.addressbookapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.addressbook.addressbookapp.model.Contact;
import com.addressbook.addressbookapp.service.AddressBook;

class AddressBookAppTests {

    AddressBook addressBook;

    @BeforeEach
    void setUp() {
        addressBook = new AddressBook();
    }

    @Test
    void givenContact_whenAdded_shouldIncreaseListSize() {

        Contact contact = new Contact(
                "Priyanshu",
                "Mishra",
                "Bhopal",
                "Bhopal",
                "MP",
                "462001",
                "9999999999",
                "pm@gmail.com");

        addressBook.addContact(contact);

        assertEquals(1, addressBook.getContacts().size());
    }

    @Test
    void givenContact_whenDeleted_shouldRemoveContact() {

        Contact contact = new Contact(
                "Priyanshu",
                "Mishra",
                "Bhopal",
                "Bhopal",
                "MP",
                "462001",
                "9999999999",
                "pm@gmail.com");

        addressBook.addContact(contact);

        addressBook.deleteContact("Priyanshu");

        assertEquals(0, addressBook.getContacts().size());
    }
    @Test
    void givenDuplicateContact_whenAdded_shouldNotIncreaseListSize() {

        Contact c1 = new Contact(
                "Priyanshu",
                "Mishra",
                "Bhopal",
                "Bhopal",
                "MP",
                "462001",
                "9999999999",
                "pm@gmail.com");

        Contact c2 = new Contact(
                "Priyanshu",
                "Mishra",
                "Bhopal",
                "Bhopal",
                "MP",
                "462001",
                "9999999999",
                "pm@gmail.com");

        addressBook.addContact(c1);
        addressBook.addContact(c2);

        assertEquals(1, addressBook.getContacts().size());
    }
    
}
