package magongwa.jeremia.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import magongwa.jeremia.student.generator.StudentNoGenerator;
import magongwa.jeremia.student.model.Student;
import magongwa.jeremia.student.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	
	
	@RequestMapping("/create")
	public String create( @RequestParam String firstName, @RequestParam String lastName, @RequestParam int age)
	{
		Student student  = studentService.create(StudentNoGenerator.StudentNo("3","GP",studentService.getAll().size()), firstName, lastName, age);
		return student.toString();
	}
	@RequestMapping("/getAll")
	public List<Student> getStudents()
	{

		return studentService.getAll();
	}
	
	@RequestMapping("/get")
	public Student getStudent(@RequestParam String firstName)
	{
	
		return studentService.getByFirstName(firstName);
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam String Student_No, @RequestParam String firstName, @RequestParam String lastName, @RequestParam int age)
	{
		Student student  = studentService.update(Student_No, firstName, lastName, age);
	    return student.toString();
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam String firstName)
	{
		studentService.delete(firstName);
		return "Deleted "+firstName;
	}
	
	@RequestMapping("/deleteAll")
	public String deleteAll()
	{
		studentService.deleteAll();
		return "Deleted all the Records";
	}
	
}
