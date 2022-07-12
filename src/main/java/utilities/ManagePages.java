package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.nopCommerce.RegisterPage;

public class ManagePages extends Base {

    public static void initNopCommerce() {

        loginPage = PageFactory.initElements(driver, pageObjects.nopCommerce.LoginPage.class);
        mainPage = PageFactory.initElements(driver, pageObjects.nopCommerce.MainPage.class);
        registerPage = PageFactory.initElements(driver, pageObjects.nopCommerce.RegisterPage.class);
        headerPage = PageFactory.initElements(driver, pageObjects.nopCommerce.HeaderPage.class);
        accountPage = PageFactory.initElements(driver, pageObjects.nopCommerce.MyaccountPage.class);
        searchPage = PageFactory.initElements(driver, pageObjects.nopCommerce.SearchPage.class);
        productPage = PageFactory.initElements(driver, pageObjects.nopCommerce.ProductPage.class);
        shopCartPage = PageFactory.initElements(driver, pageObjects.nopCommerce.ShoppingCartPage.class);
        checkoutPage = PageFactory.initElements(driver, pageObjects.nopCommerce.CheckoutPage.class);
        // init duckduckgo page
        duckSearhPage = PageFactory.initElements(driver, pageObjects.duckduckgo.DuckduckgoPage.class);
    }

    public static void initMortagage() {
        martgageMain = new pageObjects.mortgage.MainPage(mobileDriver);
    }

    public static void initToDo() {
        toDoMain = PageFactory.initElements(driver, pageObjects.toDo.MainPage.class);
    }

    public static void initCalculter() {
        calcMain = PageFactory.initElements(driver, pageObjects.calculator.MainPage.class);
    }
}
