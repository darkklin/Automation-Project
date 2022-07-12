package workflows;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import utilities.CommonOps;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class WebFlows extends CommonOps {

    @Step("Business Flow: login")
    public static void login(String user, String pass) {
        UIActions.click(headerPage.link_login);
        UIActions.updateText(loginPage.field_Email, user);
        UIActions.updateText(loginPage.field_password, pass);
        UIActions.click(loginPage.btn_login);

    }

    @Step("Business Flow: Registration")
    public static void registration(String randomEmail) {
        UIActions.click(headerPage.link_register);
        UIActions.click(registerPage.radio_genderMale);
        UIActions.updateText(registerPage.field_firstName, "test");
        UIActions.updateText(registerPage.field_lastName, "test");
        UIActions.updateDropDown(registerPage.select_dateOfBirthDay, "4");
        UIActions.updateDropDown(registerPage.select_dateOfBirthMonth, "April");
        UIActions.updateDropDown(registerPage.select_dateOfBirthYear, "1951");
        UIActions.updateText(registerPage.field_email, randomEmail);
        UIActions.updateText(registerPage.field_company, "test");
        UIActions.updateText(registerPage.field_password, "123456");
        UIActions.updateText(registerPage.field_confirmPassword, "123456");
        UIActions.click(registerPage.btn_password);

    }

    @Step("Business Flow: Log out")
    public static void logOut() {
        UIActions.click(headerPage.link_logOut);
    }

    @Step("Business Flow: Search product")
    public static void searchItem(String itemName) {
        UIActions.updateText(headerPage.fild_search, itemName);
        UIActions.click(headerPage.btn_search);

    }

    @Step("Business Flow: Add product to Shopping cart")
    public static void addProductToShoppingCart(String nameProduct) {
        searchItem(nameProduct);
        UIActions.click(searchPage.btn_addToCart);
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS); //for firefox Lags need to find better solution
        UIActions.click(productPage.btn_addToCart);
        UIActions.click(headerPage.link_shoppingCart);

    }

    @Step("Business Flow: Agree to terms and press check out ")
    public static void checkOut() {
        UIActions.click(shopCartPage.checkBox_agreeTerms);
        UIActions.click(shopCartPage.btn_checkOut);

    }

    @Step("Business Flow:Fill address shipping details and navigate to payment with viza ")
    public static void fillShippingAddressDetails() {
        UIActions.updateDropDown(checkoutPage.country_select, "Israel");
        checkoutPage.fields_shippingAdress.stream()
                .skip(4)
                .forEach(field -> UIActions.updateText(field, "demo"));
        UIActions.click(checkoutPage.btn_save);

    }

    @Step("Business Flow:Choose shipping method - Next Day Air-")
    public static void shippingMethod() {
        UIActions.click(checkoutPage.radio_shppingOptions.get(2));
        UIActions.click(checkoutPage.btn_continue.get(2));

    }

    @Step("Business Flow:Choose payment method -Credit Card- ")
    public static void choosePaymentMethod() {
        UIActions.click(checkoutPage.radio_paymentMethod.get(1));
        UIActions.click(checkoutPage.radioBtn_creditCard);
        UIActions.click(checkoutPage.btn_continue.get(3));


    }

    @Step("Business Flow:Fill credit card details ")
    public static void fillcreditCard(String cardNmae, String cardNm, String year, String code) {
        UIActions.updateText(checkoutPage.field_cardholderName, cardNmae);
        UIActions.updateText(checkoutPage.field_cardNumber, cardNm);
        UIActions.updateDropDown(checkoutPage.select_expireYear, year);
        UIActions.updateText(checkoutPage.field_cardCode, code);

    }

    @Step("save credit card details ")
    public static void savePayMentInfo() {
        UIActions.click(checkoutPage.btn_savePayMentinfo);
    }

    @Step("s")
    public static void getError(String errorMessage) {
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);

        Verifications.verifyTextInElement(checkoutPage.text_errorMessage.get(0), errorMessage);

    }

    @Step("clean")
    public static void cleanCardField() {
        checkoutPage.fields_card.stream()
                .skip(9)
                .forEach(field -> field.clear());
    }

}
