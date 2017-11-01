package ru.stqa.pft.addressbook.Tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTest extends TestBase {
    //после наследования от класса TestBase --> pull members up --> переносит методы в TestBase

    @Test
    public void testGroupCreation() {
        app.gotoGroupPage(); //extract methods
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("test1", "test2", "test3"));
        //вызывается метод fillGroupForm --> в нем создается объект GroupData --> и принимает значения
        app.submitGroupCreation();
        app.returnToGroupPage();
    }
}
