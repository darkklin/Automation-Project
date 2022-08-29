package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;

import java.util.List;

import static org.testng.Assert.*;

public class Verifications extends CommonOps {

    @Step("verify text Element")
    public static void verifyTextInElement(WebElement elem, String expected) {

        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expected);
    }
    @Step("verify Value Element")
    public static void verifyValueInElement(WebElement elem, String expected) {

        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getAttribute("value"), expected);
    }

    @Step("verify numbers of Elements")
    public static void numberOfElements(List<WebElement> elems, int expected) {
        wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size() - 1)));
        assertEquals(elems.size(), expected);
    }

    @Step("verify visibility of elements (Soft-Assertion)")
    public static void visibilityOfElements(List<WebElement> elems) {

        elems.stream()
                .forEach(elem -> softAssert.assertTrue(elem.isDisplayed(), "sorry " + elem.getText() + "not displayed"));

        softAssert.assertAll("Some Elements were not displayed");
    }

    @Step("Verify Element Visually ")
    public static void visualElement(String expectedImageImage) {
        try {
            screen.find(getData("ImageRepo") + expectedImageImage + ".png");
        } catch (FindFailed findFailed) {
            System.out.println("Error comparing Image File: " + findFailed);
            fail("Error comparing Image File: " + findFailed);
        }
    }

    @Step("Verify Text")
    public static void verifyText(String actual, String expected) {
        assertEquals(actual, expected);

    }

    @Step("Verify numbrt ")
    public static void verifyNumber(int actual, int expected) {
        assertEquals(actual, expected);

    }



}
