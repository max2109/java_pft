package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd); //обращение к конструктору базового класса
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) { //метод принимает один параметер GroupData (объект)
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteSelectedGroups() { click(By.name("delete"));
    }

    public void selectGroup(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();  } //позволяет выбирать элемент по индексу

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void create(GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupPage();
    }
    public void modify(int index, GroupData group) {
        selectGroup(index);
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();
        returnToGroupPage();
    }

    public void delete(int index) {
        selectGroup(index); //берем кол-во списка и вычитаем еденицу
        deleteSelectedGroups();
        returnToGroupPage();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupCount() { //новый метод будет считать количество групп
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<GroupData> list() {
        List<GroupData> groups = new ArrayList<GroupData>(); //создаем список groups
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group")); //список будет извлекаться из webElements
        for (WebElement element: elements){ //создаем цикл, чтобы по всем элементам прошла переменная element
            String name = element.getText(); //получаем текс (имя) из каждого элемента цикла
            //String id = element.findElement(By.tagName("input")).getAttribute("value");
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value")); //преоразованеи строки в числос помощью Integer.parseInt
            GroupData group = new GroupData(id, name, null, null); //создаем объект GroupData
            groups.add(group); //добавляем созданный объект в список
        }
        return groups;
    }
}
