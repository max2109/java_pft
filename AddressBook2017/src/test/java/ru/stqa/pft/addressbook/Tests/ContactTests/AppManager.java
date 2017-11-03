package ru.stqa.pft.addressbook.Tests.ContactTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import ru.stqa.pft.addressbook.appmanager.ContactHelper;

import java.util.concurrent.TimeUnit;

public class AppManager {

    WebDriver wd;

    private SessHelper sessHelper;
    private NavHelper navHelper;
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
        sessHelper = new SessHelper(wd);
        navHelper = new NavHelper(wd);
        sessHelper.login("admin", "secret");
    }

    protected void stop() {
        wd.quit();
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public NavHelper getNavHelper() {
        return navHelper;
    }
}
