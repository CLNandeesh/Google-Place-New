package utilities;

import org.json.JSONObject;

import io.restassured.path.json.JsonPath;

public class ValidationUtils {

	// to check specific key is present or not
	public static boolean jasonHasKey(String json, String key) {
		JSONObject jsonObject = new JSONObject(json);

		return jsonObject.has(key);

	}

	// to send specific value of a key
	public static String getJsonKeyValue(String json, String key) {
		JSONObject jsonObject = new JSONObject(json);
		// ExtentListeners.testReport.get().info("Validatng Json has key value "+key);

		return jsonObject.get(key).toString();
	}

	// To check specific field(Key value) is null
	public static boolean keyValueIsNull(String json, String key) {

		JSONObject jsonObject = new JSONObject(json);
		// ExtentListeners.testReport.get().info("Validatng Is Key value is null");
		return jsonObject.isNull(key);

	}

	// to check response is empty
	public static boolean responseIsEmpty(String json) {
		JSONObject jsonObject = new JSONObject(json);
		// ExtentListeners.testReport.get().info("Validatng Is response is null");
		return jsonObject.isEmpty();

	}

	// returns lenght of reposne
	public static int lengthOfResponse(String json) {
		JSONObject jsonObject = new JSONObject(json);
		// ExtentListeners.testReport.get().info("Validatng legth of response");

		return jsonObject.length();
	}

	// To get value for a key using JsonPath
	public static String getValueFoKey(String response, String key) {
		// To get value for a key
		JsonPath js = new JsonPath(response);

		String value = js.getString(key);

		return value;
	}

}
