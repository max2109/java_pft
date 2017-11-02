package ru.stqa.pft.addressbook.Tests.ContactTests;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.Tests.ContactData3;

public class Helper extends HelperBasic {

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

    protected void fillContactCreationForm(ContactData3 contactData3) {
        type(By.name("firstname"), contactData3.getFirstname());
        type(By.name("lastname"), contactData3.getLastname());
        type(By.name("title"), contactData3.getTitle());
        type(By.name("company"), contactData3.getCompany());
        type(By.name("address"), contactData3.getAddress());
        type(By.name("home"), contactData3.getHome());
        type(By.name("email"), contactData3.getEmail());
    }

    protected void selectContactForModification() {
       click(By.xpath("//table[@id='maintable']/tbody/tr[12]/td[8]/a/img"));
    }

    protected void fillModificationForm(ContactData3 contactData3) {
        type(By.name("firstname"), contactData3.getFirstname());
        type(By.name("lastname"), contactData3.getLastname());
    }
    protected void submitModificationForm() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }
}
