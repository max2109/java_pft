package ru.stqa.pft.addressbook.Tests.ContactTests;

import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.Tests.ContactData3;

public class ContactModificationTest3 extends TestBasic {


    @Test
    public void ContactModificationTest3() {

        appman.getNavHelepr().goToHomePage();
        appman.getHelper().selectContactForModification();
        appman.getHelper().fillModificationForm(new ContactData3("lexa", "das", null, null,null,null,null));
        appman.getHelper().submitModificationForm();
        appman.getNavHelepr().goToHomePage();
    }
}
