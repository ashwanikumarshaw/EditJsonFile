import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.*;

import org.apache.commons.io.FileUtils;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import lombok.SneakyThrows;
import test.responsePOJO;
import test.responsePOJO.*;

public class UsePojo {
	static responsePOJO res=new responsePOJO();
	@SneakyThrows
	public static void setValue(String name,String Roll,String subname,String grade,ArrayList<Map<String,String>> Mark) {
		
		res.setName(name);
		res.setRoll(Roll);
		res.setSub(new ArrayList<Subject>());
		responsePOJO.Subject sub =res.new Subject();
		sub.setGrade(grade);
		sub.setSubname(subname);
		sub.setMark(new ArrayList<Marks>());
		
		ArrayList<Marks> ArrMark=new ArrayList<>();
		for(int i=0;i<Mark.size();i++) {
			responsePOJO.Marks mark = res.new Marks();
			mark.setScore(Mark.get(i).get("score"));
			mark.setSem(Mark.get(i).get("sem"));

			ArrMark.add(mark);
			
		}
		sub.setMark(ArrMark);
		ArrayList<Subject> ArrSub=new ArrayList<>();
		ArrSub.add(sub);
		res.setSub(ArrSub);
		
		
		
		String path = "src/test/java/inputfile/test.json";

		File inputFile = new File(path);

		String reader = FileUtils.readFileToString(inputFile, StandardCharsets.UTF_8);
		DocumentContext document = JsonPath.parse(reader);
		
		JsonPath pathToArray = JsonPath.compile("$");
		document.add(pathToArray, res);

		//System.out.println(document.jsonString());
		
		//File file = new File("src/test/java/inputfile/test.json");
		FileUtils.writeStringToFile(inputFile, document.jsonString());
	}
	
	@SneakyThrows
	public static void setGradeVal(String subname,String grade,ArrayList<Map<String,String>> Mark) {
		
		
		
		responsePOJO.Subject sub =res.new Subject();
		sub.setGrade(grade);
		sub.setSubname(subname);
		sub.setMark(new ArrayList<Marks>());
		
		ArrayList<Marks> ArrMark=new ArrayList<>();
		for(int i=0;i<Mark.size();i++) {
			responsePOJO.Marks mark = res.new Marks();
			mark.setScore(Mark.get(i).get("score"));
			mark.setSem(Mark.get(i).get("sem"));

			ArrMark.add(mark);
			
		}
		sub.setMark(ArrMark);
		
		
		String path = "src/test/java/inputfile/test.json";

		File inputFile = new File(path);

		String reader = FileUtils.readFileToString(inputFile, StandardCharsets.UTF_8);
		DocumentContext document = JsonPath.parse(reader);
		
		int len=Integer.parseInt(JsonPath.parse(reader).read("$.length()").toString())-1;
		
		JsonPath pathToArray = JsonPath.compile("$["+len+"].sub");
		document.add(pathToArray, sub);

		//System.out.println(document.jsonString());
		
		//File file = new File("src/test/java/inputfile/test.json");
		FileUtils.writeStringToFile(inputFile, document.jsonString());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//setValue("Ashu", "05", "Maths", "A", "4th", "85");
		ArrayList<Map<String,String>> Mark=new ArrayList<>();
		Map<String,String> mark=new HashMap<String, String>();
		mark.put("sem", "1st");
		mark.put("score","90");
		Mark.add(mark);
		Map<String,String> mark1=new HashMap<String, String>();
		mark1.put("sem", "2st");
		mark1.put("score","49");
		Mark.add(mark1);
		setValue("Raj", "06", "Maths", "A", Mark);
		
		setGradeVal("English", "B", Mark);
		
	}

}
