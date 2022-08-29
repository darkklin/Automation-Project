package pageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage {

    @FindBy(id = "termsofservice")
    public WebElement checkBox_agreeTerms;


    @FindBy(id = "checkout")
    public WebElement btn_checkOut;

    @FindBy(className = "product-name")
    public WebElement link_productName;



}
