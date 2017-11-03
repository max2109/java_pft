package ru.stqa.pft.addressbook.Tests.ContactTests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBasic {

    @Test
    public void ContactCreationTest3() {
        appman.getContactHelper().initContactCreation();
        appman.getContactHelper().fillContactCreationForm(new ContactData("Max", "Dasya", "CEO", "DMD", "Los Angeles", "Los Angeles", "daniel.dashkoff@dmd.com", "test1"), true);
        appman.getContactHelper().submitContactCreation();
        appman.getNavHelepr().goToHomePage();
    }
}
