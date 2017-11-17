package ru.stqa.pft.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTest extends TestBase {

    @Test
    public void contactDeletionTest() {
        app.goTo().gotoHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Max", "Dasya", "CEO", "DMD", "Los Angeles", "(323)652-7788", "(323)652-5555", "daniel.dashkoff@dmd.com", "test1"), true);
        }
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().selectContactForEdit();
        app.getContactHelper().deleteContactFromEdit();
        app.goTo().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}
