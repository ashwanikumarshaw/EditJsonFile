package test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class jsonHandle {

	public static void main(String[] args) {
	

		String path = "D:\\INSTALL\\QAE\\eclipse_Workspace\\editJson\\src\\test\\java\\inputfile\\input0.json";
		//path="D:\\INSTALL\\QAE\\eclipse_Workspace\\editJson\\src\\test\\java\\inputfile\\input1.json";
		 
		File inputFile = new File(path);

		String reader = null;

		try {
			reader = FileUtils.readFileToString(inputFile, StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		char first = reader.charAt(0);

		JsonObject jsonObject;
		JsonArray jsonarray;
		if (first == '{') {
			jsonObject = JsonParser.parseString(reader).getAsJsonObject();
			System.out.println("jsonObject old" + jsonObject);

			String scenario = "a001";
			Map<String, String> m = new HashMap<>();

			m.put("Attibute", "Phones[0].sec.code");
			// test : firstName
			// Phones[0].sec.code
			// plugin.acc.data.point
			// Phones[0].Mobile
			// a[0].c[1].e
			// a1.b1[0].d[0].e

			m.put(scenario, "Ashwani");
			JsonUtil.updateJson(m, jsonObject, scenario);

			System.out.println("jsonObject new" + jsonObject);
			}
		else if (first == '[') {
			jsonarray = JsonParser.parseString(reader).getAsJsonArray();
			System.out.println("jsonObject old" + jsonarray);

			String scenario = "a001";
			Map<String, String> m = new HashMap<>();

			m.put("Attibute", "array[0].a");
			// test : firstName
			// Phones[0].sec.code
			// plugin.acc.data.point
			// Phones[0].Mobile
			// a[0].c[1].e
			// a1.b1[0].d[0].e

			m.put(scenario, "Ashwani");
			JsonUtil.updateJson(m, jsonarray, scenario);

			System.out.println("jsonObject new" + jsonarray);
			}

		
	}

}
