package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String id;
    private final String firstname;
    private final String lastname;
    private final String title;
    private final String company;
    private final String address;
    private final String home;
    private final String mobile;
    private final String email;
    private final String group;

    public ContactData(String id, String firstname, String lastname, String title, String company, String address, String home, String mobile, String email, String group) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.title = title;
        this.company = company;
        this.address = address;
        this.home = home;
        this.mobile = mobile;
        this.email = email;
        this.group = group;
    }
    public ContactData( String firstname, String lastname, String title, String company, String address, String home, String mobile, String email, String group) {
        this.id = null;
        this.firstname = firstname;
        this.lastname = lastname;
        this.title = title;
        this.company = company;
        this.address = address;
        this.home = home;
        this.mobile = mobile;
        this.email = email;
        this.group = group;
    }

    public String getFirstname() {
        return firstname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {

        return "ContactData{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    public String getId() { return id; }
    public String getLastname() { return lastname; }
    public String getTitle() { return title; }
    public String getCompany() { return company; }
    public String getAddress() { return address; }
    public String getHome() { return home; }
    public String getMobile() { return mobile; }
    public String getEmail() { return email; }

    public String getGroup() { return group; }


}
