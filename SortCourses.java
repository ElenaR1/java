public void sort() {
		int size=grades.length;
		int i, j, first;
		double temp;
		Course tempCourse;
		for ( i=0;i<size;i++) {
			 first = 0;                 // initialize to subscript of first element
	           for (j=1; j<=i; j++)   // locate smallest between positions 1 and i.
	          {
	                 if (grades[j] < grades[first] && grades[j]!=0.0 && grades[first]!=0.0)
	                 first = j;
	          }
	         temp = grades[first];   // Swap smallest found with element in position i.
	         grades[first] = grades[i];
	         grades[i] = temp;
	         
	         tempCourse=courses[first];
	         courses[first]=courses[i];
	         courses[i]=tempCourse;
		}
	}
	public void printGrades() {
		int size=grades.length;
		for (int i=0;i<size;i++) {
			if(grades[i]!=0.0)
			System.out.println(grades[i]);
		}
	}
	
	public void printCourses() {
		int size=courses.length;
		for (int i=0;i<size;i++) {
			if(courses[i]!=null)
			System.out.println(courses[i].getName());
		}
	}
	public void printCourses2(Course[] c) {
		int size=c.length;
		for (int i=0;i<size;i++) {
			if(c[i]!=null)
			System.out.println(c[i].getName());
		}
	}
	
	public void sortCourses()
	{
		Course[] newCourses=new Course[this.numOfCourses];
		int size=grades.length;
		int i, j, first;
		double temp;
		Course tempCourse;
		for ( i=0;i<size;i++) {
			 first = 0;                 // initialize to subscript of first element
	           for (j=1; j<=i; j++)   // locate smallest between positions 1 and i.
	          {
	                 if (grades[j] < grades[first] && grades[j]!=0.0 && grades[first]!=0.0)
	                 first = j;
	          }
	         temp = grades[first];   // Swap smallest found with element in position i.
	         grades[first] = grades[i];
	         grades[i] = temp;
	         
	         tempCourse=courses[first];
	         courses[first]=courses[i];
	         courses[i]=tempCourse;
		}
		System.out.println(numOfCourses);
		
		for(int i1=0; i1<numOfCourses;i1++) {
			newCourses[i1]=new Course(this.courses[i1].getName(),this.courses[i1].getId(),
					this.courses[i1].getCredit(),this.courses[i1].getType());
		}
		this.printCourses2(newCourses);
		//return newCourses;
	}
  
  
  public void addGrade(Course course,double grade)
	{
		if(numOfCourses<N && grade>2)
		{
		courses[numOfCourses]=course;
		numOfGrades=numOfCourses;
		grades[numOfGrades]=grade;
		//course.setGrade(this, grade);
		numOfCredits+=course.getCredit();	
		numOfCourses+=1;
		numOfGrades=numOfCourses;
		}
		
		else
		{
			System.out.println("No more courses are allowed");
		}
		
	}
