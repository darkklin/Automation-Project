package workflows;

import extensions.MobileAction;
import utilities.CommonOps;

public class MobileFlows extends CommonOps {

    public static void calculateMortage(String amount,String term,String rate){

        MobileAction.updateText(martgageMain.field_etAmount,amount);
        MobileAction.updateText(martgageMain.field_etTerm,term);
        MobileAction.updateText(martgageMain.field_etRate,rate);
        MobileAction.tap(martgageMain.btn_calculate);




    }
}
