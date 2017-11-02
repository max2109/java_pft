package ru.stqa.pft.addressbook.Tests;

public class ContactData3 {
    private final String firstname;
    private final String lastname;
    private final String title;
    private final String company;
    private final String address;
    private final String home;
    private final String email;

    public ContactData3(String firstname, String lastname, String title, String company, String address, String home, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.title = title;
        this.company = company;
        this.address = address;
        this.home = home;
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getHome() {
        return home;
    }

    public String getEmail() {
        return email;
    }
}
