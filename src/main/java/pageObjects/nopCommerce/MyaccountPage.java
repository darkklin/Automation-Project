package pageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyaccountPage {

    @FindBy(xpath = "//div[@class='block block-account-navigation']//li//a")
    public List<WebElement> list_accountNagivgrat;


}
