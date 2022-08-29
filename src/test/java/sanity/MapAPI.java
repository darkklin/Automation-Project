package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MapApiFlows;


@Listeners(utilities.Listeners.class)
public class MapAPI extends CommonOps {

    @Test(description = "Test01: verify Key Size")
    @Description("Test size of key Place ")
    public void test01_verifyKeySize() {
        String place_id = MapApiFlows.addPlace("Qa test ");
        Verifications.verifyNumber(place_id.length(), 32);
        MapApiFlows.deletePlace(place_id);

    }

    @Test(description = "Test02: Delete Place")
    @Description("Test delete request")
    public void test02_deletePlace() {
        String place_id = MapApiFlows.addPlace("delete place ");
        String status = MapApiFlows.deletePlace(place_id);
        Verifications.verifyText(status, "OK");
    }

    @Test(description = "Test03: Update Address")
    @Description("Test update request")
    public void test03_updateAddress() {
        //update adress
        String randomAdress =generateRandom("ab sd 234 @#");
        String msg=  MapApiFlows.update("23ce57bfa0ad17ca3fe769eb2193de39","address",randomAdress);
        Verifications.verifyText(msg, "Address successfully updated");

        //verify update
        String address = MapApiFlows.getInfoPlace("23ce57bfa0ad17ca3fe769eb2193de39", "address");
        Verifications.verifyText(address, randomAdress);


    }
    @Test(description = "Test04: Get info")
    @Description("Test get request")
    public void test03_getInfo() {
        String phone = MapApiFlows.getInfoPlace("23ce57bfa0ad17ca3fe769eb2193de39", "phone_number");
        Verifications.verifyText(phone, "(+91) 983 893 3937");
    }

}
