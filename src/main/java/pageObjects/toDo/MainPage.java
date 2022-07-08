package pageObjects.toDo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage {

    @FindBy(className ="input_b5pqF" )
    public WebElement field_createTask;

    @FindBy(className ="view_2Ow90" )
    public List<WebElement> listTask;

    @FindBy(css ="svg[class='destroy_19w1q']>path" )
    public List<WebElement> btn_x;
}
