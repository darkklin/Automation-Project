package sanity;

import extensions.Verifications;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import utilities.ManageDDT;
import workflows.DuckduckgoFlow;

@Listeners(utilities.Listeners.class)
public class DuckduckgoWeb extends CommonOps {

    @Test(description = "Test05_searchProductVerifyPrice",dataProvider = "Search-keyword",dataProviderClass = ManageDDT.class)
    public void test01_search(String keyword,String videoNm){
        DuckduckgoFlow.goTo();
        DuckduckgoFlow.doSearch(keyword);
        DuckduckgoFlow.goToVideos();
        Verifications.verifyNumber(duckSearhPage.allVideos.size(),Integer.parseInt(videoNm));

    }
}
