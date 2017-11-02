package ru.stqa.pft.addressbook.Tests.ContactTests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBasic {


    @Test
    public void ContactModificationTest3() {

        appman.getNavHelepr().goToHomePage();
        appman.getHelper().selectContactForModification();
        appman.getHelper().fillModificationForm(new ContactData("lexa", "das", null, null,null,null,null));
        appman.getHelper().submitModificationForm();
        appman.getNavHelepr().goToHomePage();
    }
}
