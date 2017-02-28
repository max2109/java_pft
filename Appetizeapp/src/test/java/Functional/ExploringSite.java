package Functional;

import org.testng.annotations.Test;

//inheritance TestBase
//pull members up
public class ExploringSite extends TestBase {

    @Test
    public void testExploringSite() {


        app.gotoEducation();
        app.goBack();
        app.gotoLeisure();
        app.GroupData(new GroupData("!@#!@#!@#!@#!@#$!@#@!#", "mail@mail.com", "!@#!@#@!#", "@#$#@$#@$@#$@#$@#$#@"));
    }

}