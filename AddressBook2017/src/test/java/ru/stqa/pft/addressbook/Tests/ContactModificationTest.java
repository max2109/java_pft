package ru.stqa.pft.addressbook.Tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Tests.TestBase;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {


    @Test
    public void ContactModificationTest3() {

        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().selectContactForModification();
        app.getContactHelper().fillModificationForm(new ContactData("vasya", "naparnase", null, null,null,null,null, null), false);
        app.getContactHelper().submitModificationForm();
        app.getNavigationHelper().gotoHomePage();
    }
}
