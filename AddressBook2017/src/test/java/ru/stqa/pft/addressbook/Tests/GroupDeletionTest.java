package ru.stqa.pft.addressbook.Tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Tests.TestBase;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

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

       // int before = app.getGroupHelper().count(); переменная доблжа быть после предусловия
        Groups before = app.group().all();//Set<GroupData> before = app.group().all(); //создание нового списка групп для сравнения
        GroupData deletedGroup = before.iterator().next();
       //  int index = before.size() -1;
       // app.getGroupHelper().selectGroup(0);
        app.group().delete(deletedGroup);
        assertThat(app.group().count(), equalTo(before.size()- 1));
        Groups after = app.group().all();// Set<GroupData> after = app.group().all();
       // Assert.assertEquals(after.size(), before.size() -1);
        //int after = app.getGroupHelper().count();       ПРОИСХОДИТ ЗАМЕНА ПЕРЕМЕННЫХ, ЧТОБЫ ОНИ СОДЕРЖАЛИ СПИСКИ, А НЕ КОЛИЧЕСТВА
        //Assert.assertEquals(after, before -1); // проверка количества групп после удаления

        //before.remove(deletedGroup);
        assertThat(after, equalTo(before.without(deletedGroup)));
        //Assert.assertEquals(before, after);
        }

}
