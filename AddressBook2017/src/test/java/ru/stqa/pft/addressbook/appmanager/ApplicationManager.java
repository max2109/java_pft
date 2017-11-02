package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init() {
        if (browser.equals (BrowserType.FIREFOX))  {
          wd = new FirefoxDriver();
        } else if (browser .equals (BrowserType.CHROME)) {
          wd = new ChromeDriver();
        } else if (browser .equals (BrowserType.IE)) {
          wd = new InternetExplorerDriver();
        }
         wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         wd.get("http://localhost/addressbook/group.php");
         groupHelper = new GroupHelper(wd);
         navigationHelper = new NavigationHelper(wd);
         sessionHelper = new SessionHelper(wd);
         sessionHelper.login("admin", "secret"); //вызов метода
    }

    public void stop() {
        wd.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public ContactHelper getContactHelper() { return contactHelper; }
}
