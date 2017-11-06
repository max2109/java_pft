package ru.stqa.pft.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTest extends TestBase{

    @Test
    public void contactDeletionTest (){
        app.getNavigationHelper().gotoHomePage();
        int before = app.getContactHelper().getContactCount();
//        if (! app.getContactHelper().isThereAContact()){
//            app.getContactHelper().createContact(new ContactData("Max", "Dasya", "CEO", "DMD", "Los Angeles", "Los Angeles", "daniel.dashkoff@dmd.com", "test1"), true));
//        }
        app.getContactHelper().selectContact(before -1 );
        app.getContactHelper().selectContactForEdit();
        app.getContactHelper().deleteContactFromEdit();
        app.getNavigationHelper().gotoHomePage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before -1); // проверка количества групп после удаления
    }
}
