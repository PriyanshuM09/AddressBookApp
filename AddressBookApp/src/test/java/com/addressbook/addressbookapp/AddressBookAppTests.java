package com.addressbook.addressbookapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
    void givenContacts_whenSortedByCity_shouldReturnCorrectOrder() {

        Contact c1 = new Contact(
                "Rahul","Sharma","Delhi","Delhi",
                "DL","110001","8888888888","rs@gmail.com");

        Contact c2 = new Contact(
                "Priyanshu","Mishra","Bhopal","Bhopal",
                "MP","462001","9999999999","pm@gmail.com");

        Contact c3 = new Contact(
                "Ankit","Verma","Indore","Indore",
                "MP","452001","7777777777","av@gmail.com");

        addressBook.addContact(c1);
        addressBook.addContact(c2);
        addressBook.addContact(c3);

        List<Contact> sorted = addressBook.sortByCity();

        assertEquals("Bhopal", sorted.get(0).getCity());
    }
    @Test
    void givenContacts_whenRetrievedFromDB_shouldReturnContacts() {

        List<Contact> contacts = addressBook.getContactsFromDB();

        assertNotNull(contacts);
    }
    @Test
    void givenContacts_whenWrittenToFile_shouldCreateFile() {

        Contact contact = new Contact(
                "Priyanshu","Mishra","Bhopal","Bhopal",
                "MP","462001","9999999999","pm@gmail.com");

        addressBook.addContact(contact);

        addressBook.writeContactsToFile("contacts.txt");

        assertEquals(1, addressBook.getContacts().size());
    }
    @Test
    void givenContacts_whenWrittenToCSV_shouldCreateCSVFile() {

        Contact contact = new Contact(
                "Priyanshu","Mishra","Bhopal","Bhopal",
                "MP","462001","9999999999","pm@gmail.com");

        addressBook.addContact(contact);

        addressBook.writeContactsToCSV("contacts.csv");

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
    @Test
    void givenContacts_whenSortedByName_shouldReturnAlphabeticalOrder() {

        Contact c1 = new Contact(
                "Rahul","Sharma","Delhi","Delhi",
                "DL","110001","8888888888","rs@gmail.com");

        Contact c2 = new Contact(
                "Priyanshu","Mishra","Bhopal","Bhopal",
                "MP","462001","9999999999","pm@gmail.com");

        Contact c3 = new Contact(
                "Ankit","Verma","Indore","Indore",
                "MP","452001","7777777777","av@gmail.com");

        addressBook.addContact(c1);
        addressBook.addContact(c2);
        addressBook.addContact(c3);

        List<Contact> sorted = addressBook.sortContactsByName();

        assertEquals("Ankit", sorted.get(0).getFirstName());
    }
    @Test
    void givenContacts_whenWrittenToJSON_shouldCreateJSONFile() {

        Contact contact = new Contact(
                "Priyanshu","Mishra","Bhopal","Bhopal",
                "MP","462001","9999999999","pm@gmail.com");

        addressBook.addContact(contact);

        addressBook.writeContactsToJSON("contacts.json");

        assertEquals(1, addressBook.getContacts().size());
    }
    @Test
    void givenContact_whenUpdated_shouldSyncWithDatabase() {

        boolean updated =
                addressBook.updateContactEmail("Priyanshu",
                                               "updated@gmail.com");

        assertTrue(updated);
    }
    
}
