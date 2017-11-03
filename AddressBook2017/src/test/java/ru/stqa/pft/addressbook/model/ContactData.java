package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String firstname;
    private final String lastname;
    private final String title;
    private final String company;
    private final String address;
    private final String home;
    private final String email;
    private final String group;

    public ContactData(String firstname, String lastname, String title, String company, String address, String home, String email, String group) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.title = title;
        this.company = company;
        this.address = address;
        this.home = home;
        this.email = email;
        this.group = group;
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

    public String getGroup() { return group; }
}
