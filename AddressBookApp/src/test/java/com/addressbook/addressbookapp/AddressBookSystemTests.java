package com.addressbook.addressbookapp;

import static org.junit.jupiter.api.Assertions.*;

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
    void givenAddressBookName_whenAdded_shouldCreateAddressBook() {

        system.addAddressBook("Friends");

        AddressBook book = system.getAddressBook("Friends");

        assertNotNull(book);
    }

    @Test
    void givenMultipleAddressBooks_whenAdded_shouldStoreAll() {

        system.addAddressBook("Friends");
        system.addAddressBook("Family");
        system.addAddressBook("Office");

        assertNotNull(system.getAddressBook("Friends"));
        assertNotNull(system.getAddressBook("Family"));
        assertNotNull(system.getAddressBook("Office"));
    }

    @Test
    void givenAddressBook_whenRetrieved_shouldReturnCorrectInstance() {

        system.addAddressBook("Work");

        AddressBook book = system.getAddressBook("Work");

        assertTrue(book instanceof AddressBook);
    }
    @Test
    void givenCity_whenSearched_shouldReturnContacts() {

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

        assertEquals(1, system.searchByCity("Bhopal").size());
    }
}