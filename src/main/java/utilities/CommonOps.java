package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import workflows.ToDoFlows;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

//commons operations
public class CommonOps extends Base {


    @BeforeTest
    @Parameters({"PlatformName"})
    public void startSession(String platformName) {
        platform = platformName;
        if (platform.equalsIgnoreCase("web"))
            initBrowser();
        else if (platform.equalsIgnoreCase("local"))
            localtest();
        else if (platform.equalsIgnoreCase("mobile"))
            initMobile();
        else if (platform.equalsIgnoreCase("api"))
            initAPI();
        else if (platform.equalsIgnoreCase("electron"))
            initElectron();
        else if (platform.equalsIgnoreCase("windows"))
            initWindows();

        else
            throw new RuntimeException("Invalid platform name");

        random = new Random();
        softAssert = new SoftAssert();

    }

    @AfterTest
    public void closeSession() {
        if (!platform.equalsIgnoreCase("api"))
            if (platform.equalsIgnoreCase("mobile")) {
                mobileDriver.quit();
            } else {

                driver.quit();

            }
    }

    @AfterMethod
    public void afterMathod() {

        if (platform.equalsIgnoreCase("electron")) {
            ToDoFlows.deleteAllTasks();

        }
    }

    //Driver initialization
    public static void initBrowser() {
        host = "localhost";

        if (System.getProperty("HUB_HOST") != null) {
            host = System.getProperty("HUB_HOST");
        }
        seleniumGridUrl = "http://" + host + ":4444/wd/hub";
        if (System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("chrome")) {

            dcc = new ChromeOptions();
        } else {

            dcc = new FirefoxOptions();

        }
        try {
            driver = new RemoteWebDriver(new URL(seleniumGridUrl), dcc);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
        action = new Actions(driver);
        driver.get(getData("url"));
//        screen = new Screen();
//        initialization pages
        ManagePages.initNopCommerce();
    }

    public void localtest(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
        action = new Actions(driver);
        driver.get(getData("url"));
        ManagePages.initNopCommerce();

    }
    public static void initMobile() {
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("AppPackage"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("AppActivity"));
        try {
            mobileDriver = new AndroidDriver<>(new URL(getData("AppiumServer") + "wd/hub"), dc);
        } catch (Exception e) {
            throw new RuntimeException("Can't connect to appium server" + e);
        }
        ManagePages.initMortagage();
        mobileDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver, 5);
        action = new Actions(mobileDriver);
    }

    public static void initAPI() {
        RestAssured.baseURI = getData("urlAPI");
        httpRequest = given();
    }

    public static void initElectron() {
        System.setProperty("webdriver.chrome.driver", getData("electronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("electronAppPath"));
        dc.setCapability("chromeOptions", opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        ManagePages.initToDo();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
        action = new Actions(driver);
    }

    public static void initWindows() {

        dc = new DesiredCapabilities();
        dc.setCapability("app", getData("CalculatorApp"));
        try {
            driver = new WindowsDriver(new URL(getData("AppiumServer")), dc);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Can't connect to appium server, see details : " + e);
        }
        ManagePages.initCalculter();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
        action = new Actions(driver);
        driver.manage().window().maximize();


    }





}
