package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

//    public void selectGroup(int index) {
//        wd.findElements(By.name("selected[]")).get(index).click();  } //позволяет выбирать элемент по индексу

    private void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']" )).click();
    }


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
    public void modify(GroupData group) {
        selectGroupById(group.getId());
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();
        returnToGroupPage();
    }

//    public void delete(int index) {
//        selectGroup(index); //берем кол-во списка и вычитаем еденицу
//        deleteSelectedGroups();
//        returnToGroupPage();
//    }

    public void delete(GroupData group) {
        selectGroupById(group.getId()); //берем кол-во списка и вычитаем еденицу
        deleteSelectedGroups();
        returnToGroupPage();
    }


    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupCount() { //новый метод будет считать количество групп
        return wd.findElements(By.name("selected[]")).size();
    }

//    public List<GroupData> list() {
//        List<GroupData> groups = new ArrayList<GroupData>(); //создаем список groups
//        List<WebElement> elements = wd.findElements(By.cssSelector("span.group")); //список будет извлекаться из webElements
//        for (WebElement element: elements){ //создаем цикл, чтобы по всем элементам прошла переменная element
//            String name = element.getText(); //получаем текс (имя) из каждого элемента цикла
//            //String id = element.findElement(By.tagName("input")).getAttribute("value");
//            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value")); //преоразованеи строки в числос помощью Integer.parseInt
//            // GroupData group =  //создаем объект GroupData
//            groups.add(new GroupData().withId(id).withName(name)); //добавляем созданный объект в список
//        }
//        return groups;
//    }
    //создаем множество
    public Groups /*Set<GroupData>*/ all() {
        Groups groups  = new Groups(); // Set<GroupData> groups = new HashSet<GroupData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element: elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groups.add(new GroupData().withId(id).withName(name));
        }
        return groups;
    }


}
