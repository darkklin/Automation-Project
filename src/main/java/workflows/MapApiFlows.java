package workflows;

import extensions.ApiAction;
import extensions.LoadAPI;
import io.qameta.allure.Step;
import org.json.simple.JSONObject;
import utilities.CommonOps;


public class MapApiFlows extends CommonOps {

    @Step("Add new place in google map")
    public static String addPlace(String placeName) {
        String placeId = ApiAction.extractFromJcon(ApiAction.sendPostRequest(LoadAPI.addPlaceJson(placeName), "maps/api/place/add/json"), "place_id");
        System.out.println("New place created ID: " + placeId);
        return placeId;

    }

    @Step("delete place  ")
    public static String deletePlace(String place_id) {
//        String status = ApiAction.extractFromJcon(ApiAction.sendPostRequest(LoadAPI.deleteJeson(place_id), "maps/api/place/delete/json"), "status");

        JSONObject requestParams = new JSONObject();
        requestParams.put("place_id", place_id);
        String status = ApiAction.extractFromJcon(ApiAction.sendPutRequest(requestParams, "maps/api/place/delete/json"), "status");
        System.out.println("ID: " + place_id + " deleted");
        return status;

    }

    @Step("get place info ")
    public static String getInfoPlace(String place_id, String extrate) {
        response = ApiAction.get(LoadAPI.getInfo(place_id));
        return ApiAction.extractFromJcon(response, extrate);
    }

    @Step("update info ")
    public static String update(String place_id, String param, String ParamValu) {
        params.put("place_id", place_id);
        params.put(param, ParamValu);
        params.put("key", "qaclick123");

        return ApiAction.extractFromJcon(ApiAction.sendPutRequest(params, "maps/api/place/update/json"), "msg");


    }


}
