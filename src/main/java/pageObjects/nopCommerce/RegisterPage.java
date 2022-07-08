package pageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage {

    @FindBy(id = "gender-male")
    public WebElement radio_genderMale;

    @FindBy(id = "LastName")
    public WebElement field_lastName;

    @FindBy(id = "FirstName")
    public WebElement field_firstName;

    @FindBy(name = "DateOfBirthDay")
    public WebElement select_dateOfBirthDay;

    @FindBy(name = "DateOfBirthMonth")
    public WebElement select_dateOfBirthMonth;

    @FindBy(name = "DateOfBirthYear")
    public WebElement select_dateOfBirthYear;

    @FindBy(id = "Email")
    public WebElement field_email;

    @FindBy(id = "Company")
    public WebElement field_company;

    @FindBy(id = "Password")
    public WebElement field_password;
    @FindBy(id = "ConfirmPassword")
    public WebElement field_confirmPassword;

    @FindBy(id = "register-button")
    public WebElement btn_password;

    @FindBy(css = ".result")
    public WebElement text_regCompleted;

    @FindBy(css = "div[class*='message-error']>ul>li")
    public WebElement text_messageError;



}
