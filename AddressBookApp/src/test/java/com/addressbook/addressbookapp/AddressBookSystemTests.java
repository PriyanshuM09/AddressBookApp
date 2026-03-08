package com.addressbook.addressbookapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.addressbook.addressbookapp.model.Contact;
import com.addressbook.addressbookapp.service.AddressBook;
import com.addressbook.addressbookapp.service.AddressBookSystem;

class AddressBookSystemTests {

    AddressBookSystem system;

    @BeforeEach
    void setUp() {
        system = new AddressBookSystem();
    }

    @Test
    void givenCity_whenViewed_shouldReturnCorrectContacts() {

        system.addAddressBook("Friends");

        AddressBook book = system.getAddressBook("Friends");

        Contact c1 = new Contact(
                "Priyanshu","Mishra","Bhopal","Bhopal",
                "MP","462001","9999999999","pm@gmail.com");

        Contact c2 = new Contact(
                "Rahul","Sharma","Delhi","Delhi",
                "DL","110001","8888888888","rs@gmail.com");

        book.addContact(c1);
        book.addContact(c2);

        system.addToDictionary(c1);
        system.addToDictionary(c2);

        assertEquals(1, system.searchByCity("Bhopal").size());
    }

    @Test
    void givenState_whenViewed_shouldReturnCorrectContacts() {

        system.addAddressBook("Friends");

        AddressBook book = system.getAddressBook("Friends");

        Contact c1 = new Contact(
                "Priyanshu","Mishra","Bhopal","Bhopal",
                "MP","462001","9999999999","pm@gmail.com");

        Contact c2 = new Contact(
                "Ankit","Verma","Indore","Indore",
                "MP","452001","7777777777","av@gmail.com");

        book.addContact(c1);
        book.addContact(c2);

        system.addToDictionary(c1);
        system.addToDictionary(c2);

        assertEquals(2, system.searchByState("MP").size());
    }
    @Test
    void givenContacts_whenCountedByCity_shouldReturnCorrectCount() {

        system.addAddressBook("Friends");

        AddressBook book = system.getAddressBook("Friends");

        Contact c1 = new Contact(
                "Priyanshu","Mishra","Bhopal","Bhopal",
                "MP","462001","9999999999","pm@gmail.com");

        Contact c2 = new Contact(
                "Rahul","Sharma","Delhi","Delhi",
                "DL","110001","8888888888","rs@gmail.com");

        Contact c3 = new Contact(
                "Ankit","Verma","Bhopal","Bhopal",
                "MP","462001","7777777777","av@gmail.com");

        book.addContact(c1);
        book.addContact(c2);
        book.addContact(c3);

        assertEquals(2, system.countByCity().get("Bhopal"));
    }
}