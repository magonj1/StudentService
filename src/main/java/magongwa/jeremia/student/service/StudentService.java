package magongwa.jeremia.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import magongwa.jeremia.student.model.Student;
import magongwa.jeremia.student.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
    
	 public List<Student> findAll() {
	        return studentRepository.findAll();
	 }

	 public Optional<Student> findById(String id) {
	        return studentRepository.findById(id);
	 }

     public Student save(Student student) {
	        return studentRepository.save(student);
	  }

	 public void deleteById(String id) {
		 studentRepository.deleteById(id);
	 }
	
}
