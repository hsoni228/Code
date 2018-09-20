package questions;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.Map;

public class JsonUtil {
	
	public static void putSafeJsonElement(JSONObject jsonObject, String jsonObjectKey, String key, String value){
		if(jsonObject==null || !jsonObject.containsKey(jsonObjectKey)){
			return;
		}
		jsonObject.getJSONObject(jsonObjectKey).element(key, value);
	}
	
	public static void putSafeJsonString(JSONObject jsonObject, String key, String value){
		
		if(jsonObject==null){
			return;
		}
		jsonObject.element(key, value);
	}
	
	public static void putSafeJsonElements(JSONObject jsonObject, String jsonObjectKey, Map<String,String> map){
		if(jsonObject==null || !jsonObject.containsKey(jsonObjectKey)){
			return;
		}
		for(String key : map.keySet()){
			putSafeJsonElement(jsonObject,jsonObjectKey,key,map.get(key));
		}
	}
		
	public static JSONArray getSafeJsonArray(JSONObject jsonObject, String key) {

		if(jsonObject==null || !jsonObject.containsKey(key)){
			return new JSONArray();
		}
		
		return jsonObject.getJSONArray(key);
	}
  

	public static String getSafeString(JSONObject jsonObject, String key) {

		if(jsonObject==null||!jsonObject.containsKey(key)){
			return "";
		}
		
		return jsonObject.getString(key);
		
	}
	public static JSONObject getSafeObject(JSONObject jsonObject, String key) {
		
    	if(jsonObject==null||!jsonObject.containsKey(key)){
			return new JSONObject();
		}
		
	    return jsonObject.getJSONObject(key);
	}


	public static double getSafeDouble(JSONObject jsonObject, String key) {

		if(jsonObject==null||!jsonObject.containsKey(key)){
			return 0d;
		}
		
	    return jsonObject.getDouble(key);

	}


	public static JSONObject getSafeObject(JSONObject jsonObject,
                                           String key, boolean returnNull) {
		
		if(jsonObject==null||!jsonObject.containsKey(key)){
			return returnNull?null:new JSONObject();
		}
		
	    return jsonObject.getJSONObject(key);
	}


	public static boolean getSafeBoolean(JSONObject jsonObject, String key) {

		if(jsonObject==null||!jsonObject.containsKey(key)){
			return false;
		}
		
	    return jsonObject.getBoolean(key);
	}

	public static  void addOnCondition(JSONObject jsonObject, String key, boolean condition, String ifConditinTrueValue, String elseValue){
		
		if(condition){
			 jsonObject.put(key, ifConditinTrueValue);
		}
		     jsonObject.put(key, elseValue);
	}


}
