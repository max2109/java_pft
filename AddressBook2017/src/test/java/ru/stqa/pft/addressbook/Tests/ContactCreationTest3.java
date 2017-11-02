package ru.stqa.pft.addressbook.Tests;

import org.testng.annotations.Test;

public class ContactCreationTest3 extends TestBasic{

    @Test
    public void ContactCreationTest3() {
        initContactCreation();
        fillContactCreationForm(new ContactData3("Daniel", "Dashkoff", "CEO", "DMD", "Los Angeles", "Los Angeles", "daniel.dashkoff@dmd.com"));
        submitContactCreation();
        goToHomePage();
    }

}
