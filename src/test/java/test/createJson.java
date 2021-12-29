package test;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class createJson {
	public static void main(String[] args) throws Exception {

		String path = "src/test/java/inputfile/input6.json";

		File inputFile = new File(path);

		String reader = FileUtils.readFileToString(inputFile, StandardCharsets.UTF_8);
		DocumentContext document = JsonPath.parse(reader);

		
		Map<String, Integer> map = new HashMap<>();
		map.put("a", 4);
		map.put("toy", null);

		JsonPath pathToArray = JsonPath.compile("$");
		document.add(pathToArray, map);
		
		Map<String, Integer> map1 = new HashMap<>();
		map1.put("Ashu", 4);
		map1.put("boy", null);
		
		Map<String, Map<String, Integer>> map2 = new HashMap<>();

		map2.put("b", map1);

		document.add(pathToArray, map2);

		pathToArray = JsonPath.compile("$");
		document.add(pathToArray, map1);
		Map<String, Integer> map3 = new HashMap<>();
		map3.put("Genul cartii", 5);

		Map<String, Map<String, Integer>> map4 = new HashMap<>();
		map4.put("ba", map3);

		document.add(pathToArray, map4);

		System.out.println(document.jsonString());
	}
	
	
}
