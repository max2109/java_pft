package ru.stqa.pft.addressbook.Tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Tests.TestBase;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupDeletionTest extends TestBase {


    @Test
    public void GroupDeletionTest() {
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("test1", "test2", null));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
    }

}