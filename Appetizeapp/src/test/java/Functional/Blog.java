package Functional;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Blog {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void testBlog() {
        wd.get("http://appetizeapp.com/blog/");
        wd.findElement(By.id("main")).click();
        wd.findElement(By.id("recent-posts-2")).click();
        wd.findElement(By.xpath("//aside[@id='recent-posts-2']/ul/li[1]/a")).click();

        wd.findElement(By.xpath("//aside[@id='recent-posts-2']/ul/li[3]/a")).click();
        wd.findElement(By.xpath("//aside[@id='recent-posts-2']/ul/li[4]/a")).click();
        wd.findElement(By.linkText("Contact")).click();
        //wd.findElement(By.xpath("//div[@class='widget-area']/aside[1]/ul/li[5]/a")).click();
        GroupData(new GroupData("!@#!@#!@#!@#!@#$!@#@!#", "mail@mail.com", "!@#!@#@!#", "@#$#@$#@$@#$@#$@#$#@"));
    }

    private void GroupData(GroupData GroupData) {
        wd.findElement(By.linkText("Contact")).click();
        wd.findElement(By.id("name")).click();
        wd.findElement(By.id("name")).clear();
        wd.findElement(By.id("name")).sendKeys(GroupData.getName());
        wd.findElement(By.id("email")).click();
        wd.findElement(By.id("email")).clear();
        wd.findElement(By.id("email")).sendKeys(GroupData.getEmail());
        wd.findElement(By.id("tel")).click();
        wd.findElement(By.id("tel")).clear();
        wd.findElement(By.id("tel")).sendKeys(GroupData.getPhone());
        wd.findElement(By.id("message")).click();
        wd.findElement(By.id("message")).clear();
        wd.findElement(By.id("message")).sendKeys(GroupData.getMessage());
        wd.findElement(By.xpath("//div[@class='contact-block']/div/form/div[3]/input")).click();
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
