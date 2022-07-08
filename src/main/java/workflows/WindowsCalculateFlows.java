package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;

public class WindowsCalculateFlows extends CommonOps {

    @Step("Calculate and return Result as string  ")
    public static String calculte(WebElement number ,WebElement operator ,WebElement two )
    {
        UIActions.click(number);
        UIActions.click(operator);
        UIActions.click(two);
        UIActions.click(calcMain.btn_Equals);
        return calcMain.field_result.getText()
                .replaceAll("[^1-9]","");

    }



}
