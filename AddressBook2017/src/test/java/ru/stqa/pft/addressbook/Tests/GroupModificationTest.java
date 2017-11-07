package ru.stqa.pft.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTest extends TestBase {

    @BeforeMethod //перед каждым тестовым методом
    public void ensurePreconditions(){
        app.goTo().groupPage(); //улучшено чтение тестов
        if (app.group().list().size() == 0) {
            app.group().create(new GroupData("test1", "test2", null));
        }
    }

    @Test
    public void testModificationTest() {
        List<GroupData> before = app.group().list();
        int index = before.size() - 1; //переменная index для упрощения записи указания в послед методах
        GroupData group = new GroupData(before.get(index).getId(), //для сохранения старого идентификатора
                "test007", "test9", "test10"); //создаем локальную переменную чтобы не писать два раза
        //int before = app.getGroupHelper().getGroupCount();
        //app.getGroupHelper().selectGroup(before -1);
        app.group().modify(index, group); //новый метод переносим в groupHelper
        List<GroupData> after = app.group().list();
        //int after = app.getGroupHelper().getGroupCount();
        //Assert.assertEquals(after, before); // проверка количества групп после можификации, должны совпасть
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(group);
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        // Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object> (after)); //для сравние нужно преобразовать списки в множества
        Assert.assertEquals(before, after);
    }

}
