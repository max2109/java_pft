package ru.stqa.pft.addressbook.Tests.GroupTests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Tests.TestBase;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTest extends TestBase {
    //после наследования от класса TestBase --> pull members up --> переносит методы в TestBase

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage(); //extract methods
        app.getGroupHelper().createGroup(new GroupData("test1", "test2", null));
    }
}
