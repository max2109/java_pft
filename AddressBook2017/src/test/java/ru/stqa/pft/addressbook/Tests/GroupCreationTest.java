package ru.stqa.pft.addressbook.Tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;

public class GroupCreationTest extends TestBase {
    //после наследования от класса TestBase --> pull members up --> переносит методы в TestBase

    @Test
    public void testGroupCreation() {
        app.goTo().groupPage(); //extract methods
        //List<GroupData> before = app.group().list();
        Groups before = app.group().all(); // Set<GroupData> before = app.group().all();
        //int before = app.getGroupHelper().count();
        GroupData group = new GroupData().withName("test2");
        app.group().create(group);
        //List<GroupData> after = app.group().list();
        assertThat(app.group().count(), equalTo(before.size()+1));
        Groups after = app.group().all();//Set<GroupData> after = app.group().all();

        assertThat(after, equalTo(before.withAdded(
                group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt())))); //add static import
    }
    @Test
    public void testBadGroupCreation() {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test2'");
        app.group().create(group);
        assertThat(app.group().count(), equalTo(before.size())); //это строка была поднята вверх чтобы ускорить тест
        Groups after = app.group().all(); //здесь загрудается список всех групп

        assertThat(after, equalTo(before));
    }
}
