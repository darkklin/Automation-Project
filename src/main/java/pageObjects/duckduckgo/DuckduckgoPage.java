package pageObjects.duckduckgo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DuckduckgoPage {

    @FindBy(name="q")
    public WebElement searchTxt;

    @FindBy(id = "search_button_homepage")
    public WebElement searchBtn;

    @FindBy(linkText = "Videos")
    public WebElement videosLink;

    @FindBy(className = "tile--vid")
    public List<WebElement> allVideos;



}
