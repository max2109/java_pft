package ru.stqa.pft.addressbook.Tests.ContactTests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBasic {


    @Test
    public void ContactModificationTest3() {

        appman.getNavigationHelper().gotoHomePage();
        appman.getContactHelper().selectContactForModification();
        appman.getContactHelper().fillModificationForm(new ContactData("vasya", "naparnase", null, null,null,null,null, null), false);
        appman.getContactHelper().submitModificationForm();
        appman.getNavigationHelper().gotoHomePage();
    }
}
