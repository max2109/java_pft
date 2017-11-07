package ru.stqa.pft.addressbook.Tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTest extends TestBase {

    @BeforeMethod //перед каждым тестовым методом
    public void ensurePreconditions(){
        app.goTo().groupPage(); //улучшено чтение тестов
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testModificationTest() {
        Groups  before = app.group().all(); // Set<GroupData> before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        //int index = before.size() - 1; //переменная index для упрощения записи указания в послед методах
        GroupData group = new GroupData().
                withId(modifiedGroup.getId()).withName("test1").withHeader("test2").withFooter("test3");
            //для сохранения старого идентификатора
              //  "test007", "test9", "test10"); //создаем локальную переменную чтобы не писать два раза
        //int before = app.getGroupHelper().getGroupCount();
        //app.getGroupHelper().selectGroup(before -1);
        app.group().modify(group); //новый метод переносим в groupHelper
        Groups after = app.group().all(); //Set<GroupData> after = app.group().all();
        //int after = app.getGroupHelper().getGroupCount();
        //Assert.assertEquals(after, before); // проверка количества групп после можификации, должны совпасть
        Assert.assertEquals(after.size(), before.size());

            //        before.remove(modifiedGroup);
            //        before.add(group);
//        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
//        before.sort(byId);
//        after.sort(byId);
        // Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object> (after)); //для сравние нужно преобразовать списки в множества
                    // Assert.assertEquals(before, after);
        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
    } //add static methods

}
