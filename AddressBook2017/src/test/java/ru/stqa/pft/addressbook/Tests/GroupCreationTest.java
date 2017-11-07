package ru.stqa.pft.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Tests.TestBase;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTest extends TestBase {
    //после наследования от класса TestBase --> pull members up --> переносит методы в TestBase

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage(); //extract methods
        List<GroupData> before = app.getGroupHelper().getGroupList();
        //int before = app.getGroupHelper().getGroupCount();
        GroupData group = new GroupData("test77", "test2", null);
        app.getGroupHelper().createGroup(group);
        List<GroupData> after = app.getGroupHelper().getGroupList();
        //int after = app.getGroupHelper().getGroupCount();
      //  Assert.assertEquals(after, before +1); // проверка количества групп после добавления
        Assert.assertEquals(after.size(), before.size()+1);

        //старый способ сравнения
//        int max = 0;
//        for (GroupData g : after){  //цикл чтобы определить максимальный идентификатор
//            if (g.getId() > max){
//                max = g.getId();
//            }
//        }

        //новый способ сравнения при помощи сравнивателя Comparator преобразованного в Лямбду

      //  group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(group);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
       // Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object> (after)); //для сравние нужно преобразовать списки в множества и сравнивать без учета порядка
        Assert.assertEquals(before, after);
    }


}
