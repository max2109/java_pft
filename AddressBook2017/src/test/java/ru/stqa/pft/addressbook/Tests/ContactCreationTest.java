package ru.stqa.pft.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Tests.TestBase;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactCreationTest extends TestBase {

    @Test
    public void ContactCreationTest() {
        int before = app.getContactHelper().getContactCount();
       // List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactCreationForm(new ContactData("julia", "sush", "CEO", "DMD", "Los Angeles", "Los Angeles", "daniel.dashkoff@dmd.com", "test007"), true);
        app.getContactHelper().submitContactCreation();
        int after = app.getContactHelper().getContactCount();
       // List<ContactData> after = app.getContactHelper().getContactList();
       // app.getNavigationHelper().gotoHomePage();
       // Assert.assertEquals(after.size(), before.size()+1);
        Assert.assertEquals(after, before +1);
    }
}
