package pageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage {

    @FindBy(linkText = "Log in")
    public WebElement link_login;

    @FindBy(linkText = "Register")
    public WebElement link_register;

    @FindBy(linkText = "Log out")
    public WebElement link_logOut;


    @FindBy(linkText = "My account")
    public WebElement link_myAccount;

    @FindBy(id = "small-searchterms")
    public WebElement fild_search;

    @FindBy(xpath = "//form[@id='small-search-box-form']//button")
    public WebElement btn_search;
    @FindBy(linkText = "shopping cart")
    public WebElement link_shoppingCart;

}
