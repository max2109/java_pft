package ru.stqa.pft.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Tests.TestBase;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;
import java.util.Set;

public class GroupDeletionTest extends TestBase {

    @BeforeMethod //перед каждым тестовым методом
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (app.group().all().size() == 0)  {
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void GroupDeletionTest() {

       // int before = app.getGroupHelper().getGroupCount(); переменная доблжа быть после предусловия
        Set<GroupData> before = app.group().all(); //создание нового списка групп для сравнения
        GroupData deletedGroup = before.iterator().next();
       //  int index = before.size() -1;
       // app.getGroupHelper().selectGroup(0);
        app.group().delete(deletedGroup);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size() -1);
        //int after = app.getGroupHelper().getGroupCount();       ПРОИСХОДИТ ЗАМЕНА ПЕРЕМЕННЫХ, ЧТОБЫ ОНИ СОДЕРЖАЛИ СПИСКИ, А НЕ КОЛИЧЕСТВА
        //Assert.assertEquals(after, before -1); // проверка количества групп после удаления

        before.remove(deletedGroup);
        Assert.assertEquals(before, after);
        }

}
