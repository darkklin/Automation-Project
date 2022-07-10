package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;


public class UIActions extends CommonOps {
    @Step("click on Element")
    public static void click(WebElement elem) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }
    @Step("Update Element")
    public static void updateText(WebElement elem, String text) {
        //wait
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }
    @Step("update drop down ")
    public static void updateDropDown(WebElement elem, String text) {
        //wait
        Select dropDown = new Select(elem);
        dropDown.selectByVisibleText(text);
    }
    @Step("Mouse Hover Element")
    public static void mouseHover(WebElement elem) {
      action.moveToElement(elem).build().perform();
    }
    @Step("Mouse Hover Element")
    public static void sendKey(WebElement elem,Keys key) {
        elem.sendKeys(key);
    }
}
