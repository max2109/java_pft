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

public class LogOut {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void LogOut() {
        wd.get("https://www.facebook.com/");
        wd.findElement(By.id("email")).click();
        wd.findElement(By.id("email")).sendKeys("\\undefined");
        wd.findElement(By.id("pass")).click();
        wd.findElement(By.id("pass")).sendKeys("\\undefined");
        wd.findElement(By.id("email")).click();
        new Actions(wd).doubleClick(wd.findElement(By.id("email"))).build().perform();
        new Actions(wd).doubleClick(wd.findElement(By.id("email"))).build().perform();
        wd.findElement(By.id("email")).click();
        wd.findElement(By.id("email")).click();
        wd.findElement(By.id("email")).clear();
        wd.findElement(By.id("email")).sendKeys("alexey2109@gmail.com");
        wd.findElement(By.id("pass")).click();
        wd.findElement(By.id("pass")).clear();
        wd.findElement(By.id("pass")).sendKeys("september8958");
        wd.findElement(By.id("u_0_q")).click();
        wd.findElement(By.id("userNavigationLabel")).click();
        wd.findElement(By.xpath("//ul[@class='_54nf']/li[16]/a/span/span")).click();
        wd.findElement(By.id("email")).click();
        wd.findElement(By.id("email")).sendKeys("\\undefined");
        wd.findElement(By.id("pass")).click();
        wd.findElement(By.id("pass")).sendKeys("\\undefined");
        wd.findElement(By.xpath("//div[1]/div[1]/div/div/div/div/div[2]/form/table/tbody/tr[2]/td[2]/input")).click();
        wd.findElement(By.xpath("//div[1]/div[1]/div/div/div/div/div[2]/form/table/tbody/tr[2]/td[2]/input")).sendKeys("\\undefined");
        wd.findElement(By.id("u_0_t")).click();
        wd.findElement(By.id("email")).click();
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
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
