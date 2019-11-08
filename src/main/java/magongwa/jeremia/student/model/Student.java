package magongwa.jeremia.student.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Student {
	
	@Id
	private String student_id;
	private String student_No;
	private String firstName;
	private String lastName;
	private int  age;
	
	
	public Student(String student_No,String firstName,String lastName,int age)
	{
		 this.student_No = student_No;
		 this.firstName = firstName;
		 this.lastName = lastName;
		 this.age = age;
	}
	
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getStudent_No() {
		return student_No;
	}
	public void setStudent_No(String student_No) {
		this.student_No = student_No;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_No=" + student_No + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", age=" + age + "]";
	}
	
    
	
}
