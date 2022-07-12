package utilities;

import io.appium.java_client.AppiumDriver;
import org.json.simple.JSONObject;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import pageObjects.duckduckgo.DuckduckgoPage;
import pageObjects.nopCommerce.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Random;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.path.json.JsonPath;

public class Base {
    //General
    protected static WebDriverWait wait;
    protected static Actions action;
    protected static Random random;
    protected static SoftAssert softAssert;
    protected static Screen screen;
    protected  static String platform;

    // Web
    protected static WebDriver driver;
    protected static String host;
    protected static String seleniumGridUrl;

    //Rest API
    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static JSONObject params = new JSONObject();
    protected static JsonPath jp;

    //Mobile
    protected static AppiumDriver mobileDriver;
    protected static DesiredCapabilities dc = new DesiredCapabilities();
    protected static MutableCapabilities dcc;



    // Page Object Web
    protected static LoginPage loginPage;
    protected static MainPage mainPage;
    protected static RegisterPage registerPage;
    protected static HeaderPage headerPage;
    protected static MyaccountPage accountPage;
    protected static SearchPage searchPage;
    protected static ProductPage productPage;
    protected static ShoppingCartPage shopCartPage;
    protected static CheckoutPage checkoutPage;
    protected static DuckduckgoPage duckSearhPage;

    // Page Object Mobile
    protected static pageObjects.mortgage.MainPage martgageMain;
    // Page Object Electron
    protected static pageObjects.toDo.MainPage toDoMain;
    // Page Object windows
    protected static pageObjects.calculator.MainPage calcMain;


    //pull data from xml file
    public static String getData(String nodeName) {
        File fXmlFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;

        try {
            fXmlFile = new File("./Configuration/DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

        } catch (Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        } finally {
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();

        }

    }
    public static String generateRandom(String text) {

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 17; i++) {
            int randIndex = random.nextInt(text.length());
            res.append(text.charAt(randIndex));
        }
        return res.toString();
    }

}
