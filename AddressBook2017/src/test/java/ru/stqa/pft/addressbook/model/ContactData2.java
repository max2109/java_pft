package ru.stqa.pft.addressbook.model;

public class ContactData2 {
    private final String firstname;
    private final String lastname;

    public ContactData2(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
