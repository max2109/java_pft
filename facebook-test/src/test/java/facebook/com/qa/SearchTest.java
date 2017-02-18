package facebook.com.qa;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class SearchTest {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void SearchTest() {
        wd.get("https://www.facebook.com/");
        wd.findElement(By.id("email")).click();
        wd.findElement(By.id("email")).sendKeys("\\undefined");
        wd.findElement(By.id("pass")).click();
        wd.findElement(By.id("pass")).clear();
        wd.findElement(By.id("pass")).sendKeys("september8958");
        wd.findElement(By.id("email")).click();
        wd.findElement(By.id("email")).clear();
        wd.findElement(By.id("email")).sendKeys("alexey2109@gmail.com");
        wd.findElement(By.id("loginbutton")).click();
        wd.findElement(By.id("u_0_q")).click();
        wd.findElement(By.linkText("Alexey")).click();
        wd.findElement(By.linkText("About")).click();
        wd.findElement(By.linkText("Photos")).click();
        wd.findElement(By.linkText("Alexey")).click();
    }
    
    @AfterMethod
    public void tearDown() { wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
