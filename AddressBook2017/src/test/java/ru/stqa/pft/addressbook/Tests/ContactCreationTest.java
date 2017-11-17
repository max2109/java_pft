package ru.stqa.pft.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Tests.TestBase;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactCreationTest extends TestBase {

    @Test                                       // (enabled = false) для выключения браузера
    public void ContactCreationTest() {

        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactCreationForm(new ContactData("A", "D", "CEO", "DMD", "Los Angeles", "(323)652-0099", "(323)000-9999","daniel.dashkoff@dmd.com", "test007"), true);
        app.getContactHelper().submitContactCreation();
        List<ContactData> after = app.getContactHelper().getContactList();
        app.goTo().gotoHomePage();
        Assert.assertEquals(after.size(), before.size()+1);

    }
}
