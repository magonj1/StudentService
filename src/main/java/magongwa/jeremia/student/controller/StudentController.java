package magongwa.jeremia.student.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import magongwa.jeremia.student.model.Student;
import magongwa.jeremia.student.service.StudentService;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200"},maxAge = 4800, allowedHeaders = "*",allowCredentials = "false")
@RestController
@RequestMapping(path = "Api/Student")
public class StudentController {

	@Autowired
	private StudentService studentService;
		
	
	@GetMapping
    public ResponseEntity<List<Student>> findAll() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Student student) {
    	
      
    	System.out.print("Create Hit  \n");
        return ResponseEntity.ok(studentService.save(student));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable String id) {
        Optional<Student> student = studentService.findById(id);
        if (!student.isPresent()) {
           
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(student.get());
    }
    @CrossOrigin(origins = {"http://localhost:4200"},maxAge = 4800, allowedHeaders = "*",allowCredentials = "false")
    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable String id, @Valid @RequestBody Student student) {
        if (!studentService.findById(id).isPresent()) {
           
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(studentService.save(student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        if (!studentService.findById(id).isPresent()) {
           
            ResponseEntity.badRequest().build();
        }

        studentService.deleteById(id);

        return ResponseEntity.ok().build();
    }
	
}
