package sanity;

import com.codeborne.selenide.testng.annotations.Report;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import utilities.ManageDDT;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class CommerceWeb extends CommonOps {

    String email;

    @Test(description = "Test01 - Registration")
    @Description("This test user registration")

    public void test01_registration() {
        email = generateRandom("zxcvbnasdfg") + "@test.com";
        WebFlows.registration(email);
        Verifications.verifyTextInElement(registerPage.text_regCompleted, "Your registration completed");
        WebFlows.logOut();
    }

    @Test(description = "Test02 - loginVerify")
    @Description("This test verifies login")
    public void test02_loginVerify() {
        WebFlows.login(email, "123456");
        Verifications.verifyTextInElement(mainPage.text_header01, "Welcome to our store");
    }

    @Test(description = "Test03 - verifyMyAccountLinks")
    @Description("This test verifies that all links appear in my account page")
    public void test03_verifyMyAccountLinks() {
        UIActions.click(headerPage.link_myAccount);
        Verifications.visibilityOfElements(accountPage.list_accountNagivgrat);
    }

    @Test(description = "Test04_VisualVerifyLogo",enabled = false)
    @Description("Visual test that verify logo")
    public void test04_VisualVerifyLogo() {
        Verifications.visualElement("logo01");
    }

    @Test(description = "Test05_searchProductVerifyPrice",dataProvider = "Search-product-price",dataProviderClass = ManageDDT.class)
    @Description("Test search product and verify Price item price")
    public void Test05_SearchProductVerifyPrice(String productName,String price) {
        WebFlows.searchItem(productName);
        Verifications.verifyTextInElement(searchPage.text_price,price);

    }



}
