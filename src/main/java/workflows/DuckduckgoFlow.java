package workflows;


import extensions.UIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class DuckduckgoFlow extends CommonOps {

    public static void goTo(){
        driver.get("https://duckduckgo.com/");
    }

    @Step("Do Search")
    public static void doSearch(String keyword) {

        UIActions.updateText(duckSearhPage.searchTxt,keyword);
        UIActions.click(duckSearhPage.searchBtn);
    }

    @Step("Go to video page ")
    public static void goToVideos(){
        UIActions.click(duckSearhPage.videosLink);
    }




}
