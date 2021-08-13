package test;

import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonUtil {

	// travel to the last element and update
	static void updateJson(Map<String, String> map, JsonObject jsonObject, String scenario) {

		String attribute = map.get("Attibute");
		String newValue = map.get(scenario);

		if (newValue.equalsIgnoreCase("blank"))
			return;
		
		String[] trav = attribute.split("\\.");

		// update in outer part

		if (trav.length == 1) {
			jsonObject.remove(attribute);
			jsonObject.addProperty(attribute, newValue);
			return;
		}

		boolean lastcovered = false;
		JsonObject temp = jsonObject;
		// iterate to the last and update
		for (int i = 0; i <trav.length ; i++) {
		
			// if next is last
			if (i  == trav.length - 1) {
				temp.remove(trav[i ]);
				temp.addProperty(trav[i ], newValue);
				return;
			}
			
			// array element
			if (trav[i].contains("[")) {
				String[] arr = trav[i].split("\\[", 2);
				String arrName = arr[0];
				int row = Integer.parseInt(arr[1].split("\\]", 2)[0]);

				JsonArray points = (JsonArray) temp.get(arrName).getAsJsonArray();

				temp = (JsonObject) points.get(row);

			} // non array
			else {

				temp = (JsonObject) temp.get(trav[i]);

			

			}

		}

	}

}
