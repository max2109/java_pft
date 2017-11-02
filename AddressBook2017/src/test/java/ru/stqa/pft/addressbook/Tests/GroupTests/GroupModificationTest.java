package ru.stqa.pft.addressbook.Tests.GroupTests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Tests.TestBase;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTest extends TestBase {

    @Test
    public void testModificationTest(){
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("test8", "test9", "test10"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();

    }



}