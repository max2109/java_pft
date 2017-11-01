package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {
    //после наследования от класса TestBase --> pull members up --> переносит методы в TestBase

    @Test
    public void testGroupCreation() {
        gotoGroupPage(); //extract methods
        initGroupCreation();
        fillGroupForm(new GroupData("test1", "test2", "test3"));
        //вызывается метод fillGroupForm --> в нем создается объект GroupData --> и принимает значения
        submitGroupCreation();
        returnToGroupPage();
    }

}
