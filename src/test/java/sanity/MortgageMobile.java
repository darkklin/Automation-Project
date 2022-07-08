package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;

@Listeners(utilities.Listeners.class)
public class MortgageMobile extends CommonOps {

    @Test(description = "Test01 - verify Mortgage")
    @Description("This test fill in mortgage fields and calculate repayment ")
    public void test01_verifyMortgage() {
        MobileFlows.calculateMortage("1000","3","4");
        Verifications.verifyTextInElement(martgageMain.resutl_repayment,"£30.03" );
    }
}
