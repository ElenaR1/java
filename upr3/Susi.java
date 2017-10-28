import exceptions.CapacityExceededException;
import exceptions.StudentAlreadyRegisteredException;
import exceptions.StudentNotFoundException;

public interface Susi {

	
	/**
	* Registers a student in the system.
	* Returns true, if the operation is successful and false, if the student
	* is already registered
	*/
	boolean registerStudent(Student student) throws StudentAlreadyRegisteredException, CapacityExceededException;

	/**
	 * Returns the number of registered students
	 */
	int getStudentsCount();
	
	/**
	* Sets a grade for the student for the specified course and adds the credits of the
	* course to the total credits of the student.
	* Returns true, if the operation is successful and false, if the student is not found
	*/
	boolean setGrade(Student student, Course course, double grade) throws StudentNotFoundException, CapacityExceededException;
	
	/**
	* Returns the total sum of credits for this student
	*/
	double getTotalCredits(Student student) throws StudentNotFoundException;
	
	/**
	* Returns the grade point average for the given student
	*/
	double getGPA(Student student) throws StudentNotFoundException;
	
    //int getCreditsPerType(Student student, CourseType type) throws StudentNotFoundException;
}