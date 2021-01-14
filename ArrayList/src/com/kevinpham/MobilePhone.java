package com.kevinpham;

import java.util.ArrayList;

public class MobilePhone {

    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }


    /**
     * Checks if a contact can be added to the list
     *
     * @param contact the contact to be added
     * @return true if contact is able to be added, false otherwise
     */
    public boolean addNewContact(Contact contact) {
        // findContact returns the index of the contact if it exists
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact is already on file.");
            return false;
        }

        myContacts.add(contact);
        return true;
    }


    /**
     * Updates and replaces old contact with new contact
     *
     * @return true if successful otherwise false
     */
    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact); // Returns the index of the contact

        if (foundPosition < 0) {
            System.out.println(oldContact.getName() + " was not found.");
            return false;
        } else if (findContact(newContact.getName()) != -1) {
            System.out.println("Contact with name " + newContact.getName() + " already exists.");
            return false;
        }

        this.myContacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + " was replaced with " + newContact.getName());
        return true;
    }


    /**
     * Remove a contact from the list
     *
     * @param contact the contact to be removed
     * @return true if successful, otherwise false
     */
    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact);
        if (foundPosition < 0) {
            System.out.println(contact.getName() + ", was not found.");
            return false;
        }
        this.myContacts.remove(foundPosition);
        System.out.println(contact.getName() + ", was deleted.");
        return true;
    }

    /**
     * Find the index of the contact
     *
     * @param contact the contact
     * @return the index of contact
     */
    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }


    /**
     * Find the contact based on the name and see if any in the list matches
     *
     * @param contactName the name of the contact to be found
     * @return the index of the contact
     */
    private int findContact(String contactName) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Get the name of a contact
     *
     * @param contact the contact
     * @return the name
     */
    public String queryContact(Contact contact) {
        if (findContact(contact) >= 0) {
            return contact.getName();
        }
        return null;
    }


    /**
     * Get the contact given the name
     *
     * @param name the contact's name
     * @return the contact
     */
    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return this.myContacts.get(position);
        }

        return null;
    }


    /**
     * Print out the list of saved contacts
     */
    public void printContacts() {
        System.out.println("Contact List");
        for (int i = 0; i < this.myContacts.size(); i++) {
            System.out.println((i + 1) + "." + this.myContacts.get(i).getName() + " -> " + this.myContacts.get(i).getPhoneNumber());
        }

    }

}
