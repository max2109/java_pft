package Functional;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Alexey on 2/27/2017.
 */
public class ApplicationManager {
    FirefoxDriver wd;

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    protected void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://appetizeapp.com/");
    }

    private void sports_entertainment() {
        wd.findElement(By.cssSelector("i.ico-ball")).click();
        wd.findElement(By.linkText("Payments")).click();
        wd.findElement(By.linkText("Back End")).click();
        wd.findElement(By.linkText("Hardware")).click();
        wd.findElement(By.linkText("Mobile Ordering")).click();
        wd.findElement(By.linkText("Parking")).click();
        wd.findElement(By.linkText("Features")).click();
        goBack();
    }

    protected void goBack() {
        wd.navigate().back();
    }

    //extract parameter object
    protected void GroupData(GroupData groupData) {
            wd.findElement(By.cssSelector("a.btn.btn-green")).click();
            wd.findElement(By.id("name")).click();
            wd.findElement(By.id("name")).clear();
            wd.findElement(By.id("name")).sendKeys(groupData.getName());
            wd.findElement(By.id("email")).click();
            wd.findElement(By.id("email")).clear();
            wd.findElement(By.id("email")).sendKeys(groupData.getEmail());
            wd.findElement(By.id("tel")).click();
            wd.findElement(By.id("tel")).clear();
            wd.findElement(By.id("tel")).sendKeys(groupData.getPhone());
            wd.findElement(By.id("message")).click();
            wd.findElement(By.id("message")).clear();
            wd.findElement(By.id("message")).sendKeys(groupData.getMessage());
            wd.findElement(By.xpath("//div[@class='contact-block']/div/form/div[3]/input")).click();
        }

    protected void gotoLeisure() {
        wd.findElement(By.linkText("Leisure")).click();
        wd.findElement(By.linkText("Kiosks")).click();
        wd.findElement(By.linkText("Back End")).click();
        wd.findElement(By.linkText("Mobile Ordering")).click();
        wd.findElement(By.linkText("Hardware")).click();
        wd.findElement(By.linkText("Features")).click();
    }

    protected void gotoEducation() {
        wd.findElement(By.linkText("Education")).click();
        wd.findElement(By.linkText("Student’s App")).click();
        wd.findElement(By.xpath("//main[@id='main']//li[.='Kiosks']")).click();
        wd.findElement(By.linkText("Kiosks")).click();
        wd.findElement(By.linkText("Campus Card")).click();
        wd.findElement(By.linkText("Hardware")).click();
        wd.findElement(By.linkText("Back End")).click();
        wd.findElement(By.linkText("Features")).click();

    }

    protected void stop() {
        wd.quit();
    }
}
