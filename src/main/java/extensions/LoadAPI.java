package extensions;

import utilities.Base;

public class LoadAPI extends Base {

    public static String addPlaceJson(String Name) {
        String json = "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"" + Name + "\",\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \"29, side layout, cohen 09\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}";
        return json;
    }

    public static String deleteJeson(String place_id) {
        String json = "{\n" +
                "    \"place_id\":\"" + place_id + "\"\n" + "}";
        return json;
    }
    public static String getInfo(String place_id) {


        return getData("urlAPI")+"maps/api/place/get/json?place_id="+place_id+"&key=qaclick123";
    }


}
