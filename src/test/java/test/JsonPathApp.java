package test;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;

import java.io.File;
import java.util.Collections;


public class JsonPathApp {
	 public static void main(String[] args) throws Exception {
	        File jsonFile = new File("src/test/java/inputfile/input5.json").getAbsoluteFile();

	        Configuration conf = Configuration.defaultConfiguration()
	                .addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL)
	                .addOptions(Option.SUPPRESS_EXCEPTIONS);
	        DocumentContext document = JsonPath.using(conf).parse(jsonFile);

	        JsonPath pathToArray = JsonPath.compile("$[0].b");

	        document.add(pathToArray, Collections.singletonMap("book", "java 3.1"));
	        document.add(pathToArray, Collections.singletonMap("book", "java 3.2"));

	        System.out.println(document.jsonString());
	    }
}
