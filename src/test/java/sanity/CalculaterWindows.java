package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;
import workflows.WindowsCalculateFlows;

@Listeners(utilities.Listeners.class)
public class CalculaterWindows extends CommonOps {


    @Test(description = "test01 add Calculate")
    @Description("test calculate 1+2=3 and verify result ")
    public void test01_add() {
        Verifications.verifyText(WindowsCalculateFlows.calculte
                        (calcMain.btn_one, calcMain.btn_Plus, calcMain.btn_Two), "3");

    }
    @Test(description = "test01 subtract Calculate")
    @Description("test calculate 5-2=3 and verify result ")
    public void test02_subtract() {
        Verifications.verifyText(WindowsCalculateFlows.calculte
                (calcMain.btn_Five, calcMain.btn_Minus, calcMain.btn_Two), "3");

    }
}
