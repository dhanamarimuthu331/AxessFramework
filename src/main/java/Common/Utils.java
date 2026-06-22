package Common;

import Drivers.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Utils {
    public static WebDriver driver;
    public static JavascriptExecutor js;
    public static Actions actions;
    public static Alert alert;
    public static WebDriverWait wait;
    public static Robot robot;

    public static void browserLaunch(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    public static void url(String url){
        DriverManager.getDriver().get(url);
    }

    public static void maximize(){
        driver.manage().window().maximize();
    }
    public static void Scroll(WebElement element){
        js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

    }
    public static void implicitwait(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    public static void close(){
        driver.close();
    }
    public static void back(){
        driver.quit();
    }
    public static void Scrollelement(WebElement element){
        js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public static void window(){
        Set<String> handles = driver.getWindowHandles();
        if(handles.size()>1){
            List<String> tab = new ArrayList<>(handles);
            driver.switchTo().window(tab.get(1));
            System.out.println("After click tab :" + driver.getWindowHandle());

        }else {
            System.out.println("No tab found open in same tab");
        }
    }
    public void javaClick(WebElement element){
        js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("arguments[0].click();", element);

    }
    public static void sendkeys(By locater, String value){
        driver.findElement(locater).sendKeys(value);
    }
    public static void explicitwait(WebDriver driver,By locater){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locater));
    }
    public static void fullscreen(String fullpage) throws IOException {
        TakesScreenshot Ts =(TakesScreenshot) driver;
        File ss = Ts.getScreenshotAs(OutputType.FILE);
        File Path =new File("");
        Files.copy(ss.toPath(),Path.toPath());
    }
    public static void singlescreenshot(WebElement element,String image) throws IOException {
        File ss1 = element.getScreenshotAs(OutputType.FILE);
        File Path = new File("");
        Files.copy(ss1.toPath(),Path.toPath());
    }
    public static void simplealert(){
        alert = driver.switchTo().alert();
    }
    public static void accept(){
        alert.accept();
    }
    public static void dismiss(){
        alert.dismiss();
    }
    public static void robotmethod(int enterkey) throws AWTException {
        robot = new Robot();
        robot.keyPress(enterkey);
        robot.keyRelease(enterkey);
    }










}
