package ru.stqa.pft.addressbook.Tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Tests.TestBase;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;

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
        //int before = app.getGroupHelper().getGroupCount();
        GroupData group = new GroupData().withName("test2");
        app.group().create(group);
        //List<GroupData> after = app.group().list();
        Groups after = app.group().all();//Set<GroupData> after = app.group().all();
        //int after = app.getGroupHelper().getGroupCount();
      //  Assert.assertEquals(after, before +1); // проверка количества групп после добавления
        assertThat(after.size(), equalTo(before.size()+1));

        //старый способ сравнения
//        int max = 0;
//        for (GroupData g : after){  //цикл чтобы определить максимальный идентификатор
//            if (g.getId() > max){
//                max = g.getId();
//            }
//        }
        //новый способ сравнения при помощи сравнивателя Comparator преобразованного в Лямбду

      //  group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
       // group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()); //function mapToInt преобразует множество в число
                                                            //проще написать функцию которая преобразует идетификатор в число, чем
                                                            //написать функцию которая сравнивает два объекта
        //before.add(group);
//        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
//        before.sort(byId);
//        after.sort(byId);
       // Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object> (after)); //для сравние нужно преобразовать списки в множества и сравнивать без учета порядка

      //  assertEquals(before, after);
        assertThat(after, equalTo(before.withAdded(
                group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt())))); //add static import
    }

}
