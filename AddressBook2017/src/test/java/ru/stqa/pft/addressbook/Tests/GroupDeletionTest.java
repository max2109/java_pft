package ru.stqa.pft.addressbook.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Tests.TestBase;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTest extends TestBase {


    @Test
    public void GroupDeletionTest() {

        app.getNavigationHelper().gotoGroupPage();

        if (! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("test1", "test2", null));
        }
       // int before = app.getGroupHelper().getGroupCount(); переменная доблжа быть после предусловия
        List<GroupData> before = app.getGroupHelper().getGroupList(); //создание нового списка групп для сравнения
       // app.getGroupHelper().selectGroup(0);
        app.getGroupHelper().selectGroup(before.size() -1); //берем кол-во списка и вычитаем еденицу
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() -1);
        //int after = app.getGroupHelper().getGroupCount();       ПРОИСХОДИТ ЗАМЕНА ПЕРЕМЕННЫХ, ЧТОБЫ ОНИ СОДЕРЖАЛИ СПИСКИ, А НЕ КОЛИЧЕСТВА
        //Assert.assertEquals(after, before -1); // проверка количества групп после удаления

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
        }
    }
