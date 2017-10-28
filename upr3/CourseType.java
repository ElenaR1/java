
public enum CourseType {
	REQUIRED ("Required","R"),// Required is CONSTANT from type enum CourseType
	ELECTIVE ("Elective","E"),
	PRACTICE ("Practice","P");
	
	CourseType(String type, String code)
	{
		this.type=type;
		this.code=code;
	}
 String type;
 String code;
}
