package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class Group2Creation extends TestBase {

    @Test
    public void testGroup2Creation() {

        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("max", "max123", "max321"));
        submitGroupCreation();
        returnToGroupPage();
        logOut();
    }

}
