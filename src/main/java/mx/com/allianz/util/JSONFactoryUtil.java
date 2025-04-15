package mx.com.allianz.util;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONFactoryUtil {
    // Create JSONObject instance
    public static JSONObject createJSONObject() {
        return new JSONObject();
    }

    // Create JSONArray instance
    public static JSONArray createJSONArray() {
        return new JSONArray();
    }
}

