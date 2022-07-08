package pageObjects.mortgage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MainPage {

    private AppiumDriver mobileDriver;

    public MainPage(AppiumDriver mobileDriver){

        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver,Duration.ofSeconds(3)), this);

    }

    @AndroidFindBy(id = "etAmount")
    public WebElement field_etAmount;

    @AndroidFindBy(id = "etTerm")
    public WebElement field_etTerm;

    @AndroidFindBy(id = "etRate")
    public WebElement field_etRate;

    @AndroidFindBy(id = "btnCalculate")
    public MobileElement btn_calculate;


    @AndroidFindBy(id = "tvRepayment")
    public WebElement resutl_repayment;

    @AndroidFindBy(id = "tvInterestOnly")
    public WebElement resutl_interestOnly;

}
