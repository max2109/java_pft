package ru.stqa.pft.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Tests.TestBase;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTest extends TestBase {
    //после наследования от класса TestBase --> pull members up --> переносит методы в TestBase

    @Test
    public void testGroupCreation() {

        app.getNavigationHelper().gotoGroupPage(); //extract methods
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().createGroup(new GroupData("test1", "test2", null));
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before +1); // проверка количества групп после добавления
    }
}
