package ru.stqa.pft.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.util.List;

public class ContactCreationTest extends TestBase {

    @Test                                       // (enabled = false) для выключения браузера
    public void ContactCreationTest() {

        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactCreation();
        File photo = new File("src\\test\\resources\\stru.png");
        app.getContactHelper().fillContactForm(
                new ContactData("A", "D", "CEO", "DMD", "Los Angeles", "(323)652-0099", "(323)000-9999", "daniel.dashkoff@dmd.com", "test007").withPhoto(photo), true);
        app.getContactHelper().submitContactCreation();
        List<ContactData> after = app.getContactHelper().getContactList();
        app.goTo().gotoHomePage();
        Assert.assertEquals(after.size(), before.size() + 1);
    }

    @Test
    public void testCurrentDir() {
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/stru.png");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());



    }
}