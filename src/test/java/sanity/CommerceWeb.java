package sanity;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.CheckoutPage;
import utilities.CommonOps;
import utilities.ManageDDT;
import workflows.WebFlows;

import java.util.function.Consumer;

@Listeners(utilities.Listeners.class)
public class CommerceWeb extends CommonOps {

    String email;

    @Test(description = "Test01 - Registration")
    @Description("This test user registration")

    public void test01_registration() {
        email = RandomStringUtils.randomAlphabetic(10) + "@test.com";
        System.out.println(email);
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

    @Test(description = "Test04_VisualVerifyLogo", enabled = false)
    @Description("Visual test that verify logo")
    public void test04_VisualVerifyLogo() {
        Verifications.visualElement("logo01");
    }

    @Test(description = "Test05_searchProductVerifyPrice", dataProvider = "Search-product-price", dataProviderClass = ManageDDT.class)
    @Description("Test search product and verify item price")
    public void test05_SearchProductVerifyPrice(String productName, String price) {
        WebFlows.searchItem(productName);
        Verifications.verifyTextInElement(searchPage.text_price, price);

    }

    @Test(description = "Test06 - addProductToShoppingCard")
    @Description("This Test add  product To shopping cart and verify it")
    public void test06_addProductToShoppingCard() {
        WebFlows.addProductToShoppingCart("Apple MacBook Pro 13-inch");
        Verifications.verifyTextInElement(shopCartPage.link_productName, "Apple MacBook Pro 13-inch");
        // need to add more verifications.

    }

    @Test(description = "Test07 - checkOut")
    @Description("This Test approve the buy order ")
    public void test07_shopingCardcheckOut() {
        WebFlows.checkOut();
        Verifications.verifyValueInElement(checkoutPage.fields_shippingAdress.get(2), email);

    }

    @Test(description = "Test08 - fillShippingDetails")
    @Description("This Test fill the shpping details fields ")
    public void test08_fillShippingDetails() {
        Verifications.numberOfElements(checkoutPage.fields_shippingAdress, 10);
        WebFlows.fillShippingAddressDetails();

    }

    @Test(description = "Test09 - chooseShipingMethod")
    @Description("This Test Choose shipping method")
    public void test09_chooseShipingMethod() {
        WebFlows.shippingMethod();
        Verifications.numberOfElements(checkoutPage.radio_shppingOptions, 3);

    }

    @Test(description = "Test10 - paymentMethod")
    @Description("This Test Choose payment method from two options(Verify that)")
    public void test10_paymentMethod() {
        WebFlows.choosePaymentMethod();
        Verifications.numberOfElements(checkoutPage.radio_paymentMethod, 2);
    }

    @Test(description = "Test12 - fillValidCreditCard")
    @Description("This Test fill valid credit card and verify transfection")
    public void test11_fillValidCreditCard() {
        WebFlows.fillcreditCard("text","4111111111111111","2023","123");
        UIActions.click(checkoutPage.btn_continue.get(4));
        Verifications.verifyTextInElement(checkoutPage.text_finalPrice, "$3,600.00");
        UIActions.click(checkoutPage.btn_confirm);
        Verifications.verifyTextInElement(checkoutPage.text_textSuccessPayment,"Your order has been successfully processed!");
    }



}
