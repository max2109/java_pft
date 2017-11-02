package ru.stqa.pft.addressbook.Tests.ContactTests;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.appmanager.HelperBase;
import ru.stqa.pft.addressbook.model.ContactData;

public class Helper extends HelperBase {

    public Helper(FirefoxDriver wd) {
        super(wd);
    }

    protected void initContactCreation() {
        click(By.linkText("add new"));
    }

    protected void submitContactCreation() {
        click(By.name("theform"));
        click(By.xpath("//div[@id='content']/form/input[21]"));
        click(By.id("content"));
    }

    protected void fillContactCreationForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("title"), contactData.getTitle());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHome());
        type(By.name("email"), contactData.getEmail());
    }

    protected void selectContactForModification() {
       click(By.xpath("//table[@id='maintable']/tbody/tr[12]/td[8]/a/img"));
    }

    protected void fillModificationForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
    }
    protected void submitModificationForm() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }
}
