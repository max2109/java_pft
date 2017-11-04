package ru.stqa.pft.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Tests.TestBase;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

    @Test
    public void ContactCreationTest() {
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactCreationForm(new ContactData("Max", "Dasya", "CEO", "DMD", "Los Angeles", "Los Angeles", "daniel.dashkoff@dmd.com", "test1"), true);
        app.getContactHelper().submitContactCreation();
        int after = app.getContactHelper().getContactCount();
        app.getNavigationHelper().gotoHomePage();
        Assert.assertEquals(after, before +1);
    }
}
