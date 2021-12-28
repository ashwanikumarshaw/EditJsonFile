package test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

import com.jayway.jsonpath.JsonPath;

public class jsonPathadd {
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
		String path = "C:\\Users\\ashwa\\git\\EditJsonFile\\src\\test\\java\\inputfile\\input5.json";
		 
		File inputFile = new File(path);

		String reader =  FileUtils.readFileToString(inputFile, StandardCharsets.UTF_8);
		Object dataObject = JsonPath.parse(reader).put("$[0].b[1]","c", "ashu").read("$");
	//	 dataObject = JsonPath.parse(reader).read("$");
		String dataString = dataObject.toString();
		
		System.out.println(dataString);
		
	}

}
