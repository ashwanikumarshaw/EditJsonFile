package test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

public class TextFileModificationProgram {
	
	    public static void main(String[] args) throws IOException
	    {
	       // modifyFile("C:\\Users\\ashwa\\git\\EditJsonFile\\src\\test\\java\\inputfile\\input4.json", "}{", "},{");
	         
	        File log= new File("C:\\Users\\ashwa\\git\\EditJsonFile\\src\\test\\java\\inputfile\\input4.json");
	        String search ="\\}\r\n\\{";  
	        String replacement =  "},{",s;
	       


			String reader =  FileUtils.readFileToString(log, StandardCharsets.UTF_8);
	        System.out.println("done"+reader.replaceAll(search, replacement));
	    }

}
