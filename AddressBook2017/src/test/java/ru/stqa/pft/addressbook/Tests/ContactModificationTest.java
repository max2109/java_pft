package ru.stqa.pft.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Tests.TestBase;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {


    @Test
    public void contactModificationTest3() {

        app.goTo().gotoHomePage();
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectContactForModification(before -1);
        app.getContactHelper().fillModificationForm(new ContactData("vasya", "naparnase", null, null,null,null,null, null), false);
        app.getContactHelper().submitModificationForm();
        app.goTo().gotoHomePage();

        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before );

    }
}
