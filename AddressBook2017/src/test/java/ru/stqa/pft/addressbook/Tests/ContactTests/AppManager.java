package ru.stqa.pft.addressbook.Tests.ContactTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import ru.stqa.pft.addressbook.appmanager.ContactHelper;
import ru.stqa.pft.addressbook.appmanager.NavigationHelper;
import ru.stqa.pft.addressbook.appmanager.SessionHelper;

import java.util.concurrent.TimeUnit;

public class AppManager {

    WebDriver wd;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private ContactHelper contactHelper;
    private String browser;

    public AppManager(String browser) {
        this.browser = browser;
    }

    protected void init() {
        if (browser.equals (BrowserType.FIREFOX))  {
            wd = new FirefoxDriver();
        } else if (browser .equals (BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser .equals (BrowserType.IE)) {
            wd = new InternetExplorerDriver();
        }
        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/group.php");
        contactHelper = new ContactHelper(wd);
        sessionHelper = new SessionHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper.login("admin", "secret");
    }

    protected void stop() {
        wd.quit();
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
