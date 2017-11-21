package ru.stqa.pft.addressbook.Tests;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Tests.TestBase;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    @DataProvider
    public Iterator<Object[]> validGroupsFromJson() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.json")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>() {
            }.getType());
            return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
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
