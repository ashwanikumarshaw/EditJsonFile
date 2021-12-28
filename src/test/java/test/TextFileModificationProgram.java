package test;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class TextFileModificationProgram {
	
	    public static void main(String[] args) throws IOException
	    {
	       // modifyFile("C:\\Users\\ashwa\\git\\EditJsonFile\\src\\test\\java\\inputfile\\input4.json", "}{", "},{");
	         
	        File log= new File(" src/test/java/inputfile/input4.json");
	        String search ="\\}\\{";//"\\}\r\n\\{";  
	        String replacement =  "},{",s;
	       


			String reader =  FileUtils.readFileToString(log, StandardCharsets.UTF_8);
			reader=reader.trim().replaceAll("\r\n ", "");
			reader=reader.replaceAll(search, replacement)+"]";
	        reader="{\"a\":["+reader.replaceAll(search, replacement)+"}";

	        System.out.println("done" + reader);
			DocumentContext json = JsonPath.parse(reader);
		    String jayPath = "$.a[*].b";
		    String tagValue = "ReplacedText";
		    System.out.println(json.set(jayPath, tagValue).jsonString());
	    }

}
