package test.pojoway;

import java.util.*;

import lombok.Data;

@Data
public class responsePOJO {
	
	private String name;
	private String Roll;
	private ArrayList<Subject> sub;
	@Data
	public class Subject{
		private String Subname;
		private String grade;
		private ArrayList<Marks> mark;
	}
	@Data
	public class Marks {
		private String sem;
		private String score;
	}

}
