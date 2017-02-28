package Functional;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by Alexey on 2/27/2017.
 */
//pull members upp
    // replace inheritance with delegation
public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();

        //extract method

    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }


    public ApplicationManager getApp() {
        return app;
    }
}

