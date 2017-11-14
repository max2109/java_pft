package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.appmanager.HelperBase;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import javax.xml.bind.Element;
import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void fillContactCreationForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("title"), contactData.getTitle());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHome());
        type(By.name("email"), contactData.getEmail());
        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void submitContactCreation() {
        click(By.name("theform"));
        click(By.xpath("//div[@id='content']/form/input[21]"));
        click(By.id("content"));
    }

    public void selectContactForModification(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();

        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void fillModificationForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
    }

    public void submitModificationForm() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteSelectedContact() {
        click(By.name("delete"));
    }

    public void selectContactForEdit() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void deleteContactFromEdit() {
        click(By.xpath("//div[@id='content']/form[2]/input[2]"));
    }

    //    private void selectContactByCheckbox(int checkbox) {
//        wd.findElement(By.cssSelector("input[value='" + id + "']" )).click();
//    private String checkbox;
    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>(); //создаем список contacts
        List<WebElement> elements = wd.findElements((By.name("selected[]"))); //список будет извлекаться из webElements    --->> can't find element !!!
        for (WebElement element : elements) { //создаем цикл, чтобы по всем элементам прошла переменная element
            String name = element.getText();
            ContactData contact = new ContactData(name, null, null, null, null, null, null, null);
            contacts.add(contact); //добавляем созданный объект в список
        }
        return contacts;
//    }
    }
}