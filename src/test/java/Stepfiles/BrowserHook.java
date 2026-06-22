package Stepfiles;

import Common.Utils;
import Drivers.DriverFactory;
import Drivers.DriverManager;
import Readers.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserHook {
    @Before
    public void browserLaunch(){
      String browser=ConfigReader.getProp("browser");
        WebDriver driver = DriverFactory.initbrowser(browser);
        DriverManager.setDriver(driver);
        Utils.driver = DriverManager.getDriver();
    }
    @After
    public void closeBrowser(){

        DriverManager.getDriver().quit();
        DriverManager.CloseDriver();
    }
}
