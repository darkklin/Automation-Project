package pageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutPage {

    @FindBy(xpath = "//div[@class='inputs']//input")
    public List<WebElement> fields_shippingAdress;

    @FindBy(id = "BillingNewAddress_CountryId")
    public WebElement country_select;

    @FindBy(name = "save")
    public WebElement btn_save;

    @FindBy(id = "paymentmethod_1")
    public WebElement radioBtn_creditCard;

    @FindBy(css = "input[name='shippingoption']")
    public List<WebElement> radio_shppingOptions;

    @FindBy(css = "input[name='paymentmethod']")
    public List<WebElement> radio_paymentMethod;

    @FindBy(id = "CardholderName")
    public WebElement field_cardholderName;

    @FindBy(id = "CardCode")
    public WebElement field_cardCode;

    @FindBy(id = "CardNumber")
    public WebElement field_cardNumber;


    @FindBy(id = "ExpireYear")
    public WebElement select_expireYear;

    @FindBy(css = "span[class='value-summary']>strong")
    public WebElement text_finalPrice;

    @FindBy(xpath = "//button[contains(text(),'Confirm')]")
    public WebElement btn_confirm;

    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    public List<WebElement> btn_continue;

    @FindBy(css = "div[class*='message-error']>ul>li")
    public List<WebElement> text_errorMessage;

    @FindBy(css = "button[onclick*='PaymentInfo.save']")
    public WebElement btn_savePayMentinfo;

    @FindBy(css = "div[class*='section order-completed']>div>strong")
    public WebElement text_textSuccessPayment;

    @FindBy(css = "input[type='text']")
    public List<WebElement> fields_card;



}
