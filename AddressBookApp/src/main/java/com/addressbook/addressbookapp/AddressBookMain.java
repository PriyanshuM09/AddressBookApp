package com.addressbook.addressbookapp;

import java.util.Scanner;

import com.addressbook.addressbookapp.model.Contact;
import com.addressbook.addressbookapp.service.AddressBook;

public class AddressBookMain {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		AddressBook addressBook = new AddressBook();

		boolean running = true;

		while (running) {

			System.out.println("\n===== Address Book Menu =====");
			System.out.println("1. Add Contact");
			System.out.println("2. Edit Contact");
			System.out.println("3. Delete Contact");
			System.out.println("4. Display Contacts");
			System.out.println("5. Exit");

			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {

			case 1:

				System.out.println("Enter First Name:");
				String firstName = scanner.nextLine();

				System.out.println("Enter Last Name:");
				String lastName = scanner.nextLine();

				System.out.println("Enter Address:");
				String address = scanner.nextLine();

				System.out.println("Enter City:");
				String city = scanner.nextLine();

				System.out.println("Enter State:");
				String state = scanner.nextLine();

				System.out.println("Enter Zip:");
				String zip = scanner.nextLine();

				System.out.println("Enter Phone Number:");
				String phone = scanner.nextLine();

				System.out.println("Enter Email:");
				String email = scanner.nextLine();

				Contact contact = new Contact(firstName, lastName, address, city, state, zip, phone, email);

				addressBook.addContact(contact);

				break;

			case 2:

				System.out.println("Enter first name to edit:");
				String nameToEdit = scanner.nextLine();

				addressBook.editContact(nameToEdit);

				break;

			case 3:

				System.out.println("Enter first name to delete:");
				String nameToDelete = scanner.nextLine();

				addressBook.deleteContact(nameToDelete);

				break;

			case 4:

				addressBook.displayContacts();

				break;

			case 5:

				running = false;
				System.out.println("Exiting Address Book...");
				break;

			default:

				System.out.println("Invalid choice!");
			}
		}

		scanner.close();
	}
}