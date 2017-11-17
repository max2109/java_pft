package ru.stqa.pft.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Tests.TestBase;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase {


    @Test
    public void contactModificationTest3() {

        app.goTo().gotoHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContactForModification(before.size() -1);
        ContactData contact = new ContactData("Michael", "Jordan", null, null,null,null,null, null, null) ;
        app.getContactHelper().fillModificationForm(contact);
        app.getContactHelper().submitModificationForm();
        app.goTo().gotoHomePage();

        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() );

        before.remove(before.size() -1);
        before.add(contact);
       // Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
