package magongwa.jeremia.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import magongwa.jeremia.student.model.Student;
import magongwa.jeremia.student.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
    
	public Student create(String student_No,String firstName,String lastName,int age)
	{
		return studentRepository.save(new Student(student_No,firstName,lastName,age));
	}
    
	public List<Student> getAll()
	{
		return studentRepository.findAll();
	}
	public Student getByFirstName(String firstName)
	{
		return studentRepository.findByFirstName(firstName);
	}
	public Student update(String student_No,String firstName,String lastName,int age)
	{
		Student student  = studentRepository.findByFirstName(firstName);
		student.setAge(age);
		student.setStudent_No(student_No);
		student.setLastName(lastName);
		return studentRepository.save(student);
	}
	public void deleteAll()
	{
		studentRepository.deleteAll();
	}
	public void delete(String firstName)
	{
		Student student  = studentRepository.findByFirstName(firstName);
		studentRepository.delete(student);
	}
	
}
