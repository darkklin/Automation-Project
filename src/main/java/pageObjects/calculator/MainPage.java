package pageObjects.calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

public class MainPage {

    @FindBy(name = "One")
    public WebElement btn_one;

    @FindBy(name = "Two")
    public WebElement btn_Two;

    @FindBy(name = "Three")
    public WebElement btn_Three;

    @FindBy(name = "Four")
    public WebElement btn_Four;

    @FindBy(name = "Five")
    public WebElement btn_Five;

    @FindBy(name = "Six")
    public WebElement btn_Six;

    @FindBy(name = "Seven")
    public WebElement btn_Seven;

    @FindBy(name = "Eight")
    public WebElement btn_Eight;

    @FindBy(name = "Nine")
    public WebElement btn_Nine;


    @FindBy(name = "Plus")
    public WebElement btn_Plus;

    @FindBy(name = "Multiply by")
    public WebElement btn_Multiply;

    @FindBy(name = "Minus")
    public WebElement btn_Minus;

    @FindBy(name = "Equals")
    public WebElement btn_Equals;

    @FindBy(name = "Divide by")
    public WebElement btn_Divide;

    @FindBy(xpath = "//*[@AutomationId='CalculatorResults']")
    public WebElement field_result;


}
