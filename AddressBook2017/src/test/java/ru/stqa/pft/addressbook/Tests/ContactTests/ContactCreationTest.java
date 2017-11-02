package ru.stqa.pft.addressbook.Tests.ContactTests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBasic {

    @Test
    public void ContactCreationTest3() {
        appman.getHelper().initContactCreation();
        appman.getHelper().fillContactCreationForm(new ContactData("Daniel", "Dashkoff", "CEO", "DMD", "Los Angeles", "Los Angeles", "daniel.dashkoff@dmd.com"));
        appman.getHelper().submitContactCreation();
        appman.getNavHelepr().goToHomePage();
    }
}
