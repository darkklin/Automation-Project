package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;
public class WebFlows extends CommonOps {

    @Step("Business Flow: login")
    public static void login(String user,String pass){
        UIActions.click(headerPage.link_login);
        UIActions.updateText(loginPage.field_Email,user);
        UIActions.updateText(loginPage.field_password,pass);
        UIActions.click(loginPage.btn_login);

    }
    @Step("Business Flow: Registration")
    public static void registration(String randomEmail){
        UIActions.click(headerPage.link_register);
        UIActions.click(registerPage.radio_genderMale);
        UIActions.updateText(registerPage.field_firstName,"test");
        UIActions.updateText(registerPage.field_lastName,"test");
        UIActions.updateDropDown(registerPage.select_dateOfBirthDay,"4");
        UIActions.updateDropDown(registerPage.select_dateOfBirthMonth,"April");
        UIActions.updateDropDown(registerPage.select_dateOfBirthYear,"1951");
        UIActions.updateText(registerPage.field_email,randomEmail);
        UIActions.updateText(registerPage.field_company,"test");
        UIActions.updateText(registerPage.field_password,"123456");
        UIActions.updateText(registerPage.field_confirmPassword,"123456");
        UIActions.click(registerPage.btn_password);

    }
    @Step("Business Flow: Log out")
    public static void logOut(){
        UIActions.click(headerPage.link_logOut);
    }

    @Step("Business Flow: Search product")
    public static void searchItem(String itemName){
        UIActions.updateText(headerPage.fild_search,itemName);
        UIActions.click(headerPage.btn_search);

    }
}
