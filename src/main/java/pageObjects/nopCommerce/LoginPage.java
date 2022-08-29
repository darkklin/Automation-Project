package pageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(id = "Email")
    public WebElement field_Email;

    @FindBy(id = "Password")
    public WebElement field_password;

    @FindBy(css = "button[class*='login-button']")
    public WebElement btn_login;



}
