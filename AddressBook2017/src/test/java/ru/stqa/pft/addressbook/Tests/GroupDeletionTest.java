package ru.stqa.pft.addressbook.Tests;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {


    @Test
    public void GroupDeletionTest() {
        app.gotoGroupPage();
        app.selectGroup();
        app.deleteSelectedGroups();
        app.returnToGroupPage();
    }

}