package ru.stqa.pft.addressbook.Tests.GroupTests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Tests.TestBase;

public class GroupDeletionTest extends TestBase {


    @Test
    public void GroupDeletionTest() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
    }

}