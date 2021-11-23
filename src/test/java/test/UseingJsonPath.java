package test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.jayway.jsonpath.*;

public class UseingJsonPath {
	/*
	 * 
	 * <!-- https://mvnrepository.com/artifact/com.jayway.jsonpath/json-path -->
	 * <dependency>
	 * <groupId>com.jayway.jsonpath</groupId>
	 * <artifactId>json-path</artifactId> 
	 * <version>2.6.0</version> 
	 * </dependency>
	 * 
	 */
	public static void main(String args[]) throws IOException {
		/*
		 *  $.store.book[0].title
			$.store.book[*].title
			$..book[3]

		//or using brackets

		$['store']['book'][0].['title']
		$['store']['book'][*].['title']
		$..['book'][3]

		$.store.book[?(@.price &lt; 10)].title
		 */
		String path = "C:\\Users\\ashwa\\git\\EditJsonFile\\src\\test\\java\\inputfile\\store.json";
		 
		File inputFile = new File(path);

		String reader =  FileUtils.readFileToString(inputFile, StandardCharsets.UTF_8);
		
		Object dataObject = JsonPath.parse(reader).read("$['store']['book'][*].['title']");
		String dataString = dataObject.toString();
		
		System.out.println(dataString);
		//Update
		DocumentContext json = JsonPath.parse(reader);
	    String jayPath = "$..book[0].author";
	    String tagValue = "ReplacedText";
	    System.out.println(json.set(jayPath, tagValue).jsonString());
		
		

		
	}

}
