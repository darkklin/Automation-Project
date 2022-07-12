package pageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage {

    @FindBy(css = "span[class*='actual-price']")
    public WebElement text_price;
    @FindBy(css = "button[class*='add-to-cart-button']")
    public WebElement btn_addToCart;
}
