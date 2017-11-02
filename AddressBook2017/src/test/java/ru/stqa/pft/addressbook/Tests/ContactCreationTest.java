package ru.stqa.pft.addressbook.Tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase{

    @Test
    public void testContactModification(){
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("test_name", "test_surname"));
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();
    }
}
