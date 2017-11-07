package ru.stqa.pft.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Tests.TestBase;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTest extends TestBase {

    @BeforeMethod //перед каждым тестовым методом
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (app.group().list().size() == 0)  {
            app.group().create(new GroupData("test1", "test2", null));
        }
    }

    @Test
    public void GroupDeletionTest() {

       // int before = app.getGroupHelper().getGroupCount(); переменная доблжа быть после предусловия
        List<GroupData> before = app.group().list(); //создание нового списка групп для сравнения
        int index = before.size() -1;
       // app.getGroupHelper().selectGroup(0);
        app.group().delete(index);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size() -1);
        //int after = app.getGroupHelper().getGroupCount();       ПРОИСХОДИТ ЗАМЕНА ПЕРЕМЕННЫХ, ЧТОБЫ ОНИ СОДЕРЖАЛИ СПИСКИ, А НЕ КОЛИЧЕСТВА
        //Assert.assertEquals(after, before -1); // проверка количества групп после удаления

        before.remove(index);
        Assert.assertEquals(before, after);
        }

}
