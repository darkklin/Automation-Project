package regression;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.ITestContext;
import org.testng.annotations.*;
import sanity.CommerceWeb;
import workflows.WebFlows;
import static workflows.actions.WebFlowActions.*;

import java.util.function.Consumer;

@Listeners(utilities.Listeners.class)
public class CVVTest extends CommerceWeb {
    WebFlows webFlows;

    @Test(dataProvider = "criticalProvider")
    public void test01_CVVValidation(Consumer<WebFlows> consumer){

    consumer.accept(webFlows);
    WebFlows.cleanCardField();

    }

    @BeforeTest
    public void beforeTest(){
        WebFlows.registration(RandomStringUtils.randomAlphabetic(10) + "@test.com");
        WebFlows.addProductToShoppingCart("Apple MacBook Pro 13-inch");
        WebFlows.checkOut();
        WebFlows.fillShippingAddressDetails();
        WebFlows.shippingMethod();
        WebFlows.choosePaymentMethod();

    }

    @DataProvider( name = "criticalProvider")
    public Object[][] testdata(ITestContext ctx){

        return new  Object[][]{
                {invalidCCV.andThen(clickSave).andThen(cardNmError)},
                {invaliDate.andThen(clickSave.andThen(cardDateError))},
                {invaliCode.andThen(clickSave.andThen(cardCodeError))},
                {invaliCardHolderName.andThen(clickSave).andThen(cardHolderError)}


        };
    }


}
