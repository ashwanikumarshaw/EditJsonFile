package test;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.*;

import org.apache.commons.io.FileUtils;


public class JsonPathApp {
	 public static void main(String[] args) throws Exception {
		 
		 String path = "src/test/java/inputfile/input5.json";
		 
			File inputFile = new File(path);

			String reader =  FileUtils.readFileToString(inputFile, StandardCharsets.UTF_8);
			
	        File jsonFile = new File("src/test/java/inputfile/input5.json").getAbsoluteFile();

	        Configuration conf = Configuration.defaultConfiguration()
	                .addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL)
	                .addOptions(Option.SUPPRESS_EXCEPTIONS);
	        
	        DocumentContext document = JsonPath.parse(reader);

	        JsonPath pathToArray = JsonPath.compile("$[0].b");

	     // Here aList is an ArrayList of ArrayLists
	        ArrayList<Map<String ,Integer> > aList = 
	                  new ArrayList<>();  
	        // Create n lists one by one and append to the 
	        // master list (ArrayList of ArrayList)
	        Map<String,Integer> map = new HashMap<>();
	        map.put ("Genul cartii",4);
	        map.put ("Limba",78);
	        map.put ("Numarul de copii",78);
	        aList.add(map);
	  
	        
	  
	        Map<String,Integer> map1 = new HashMap<>();
	        map1.put ("Genul cartii",4);
	        map1.put ("Limba",78);
	        map1.put ("Numarul de copii",78);
	        aList.add(map1);
	  
	        for (int i = 0; i < aList.size(); i++) {
	        	document.add(pathToArray, aList.get(i));
	            
	        }
	        document.add(pathToArray, Collections.singletonMap("book", "java 3.2"));

	        System.out.println(document.jsonString());
	    }
}
