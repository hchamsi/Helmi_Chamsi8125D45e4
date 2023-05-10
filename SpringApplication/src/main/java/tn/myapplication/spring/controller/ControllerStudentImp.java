package tn.myapplication.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.myapplication.spring.dto.StudentDTO;
import tn.myapplication.spring.entity.Student;
import tn.myapplication.spring.service.StudentService;

@RestController
@RequestMapping("/students")
public class ControllerStudentImp {
	private final StudentService studentService;

	@Autowired
	public ControllerStudentImp(StudentService studentService) {
		this.studentService = studentService;
	}

	// - Get the list of students with the following:
	// - Filters: Class Name and/or Teacher Full Name
	// - All Students list will be returned in case of no filters value
	// - Paginated
	// URL : http://localhost:8082/getstudents
	@GetMapping
	@RequestMapping("/getstudents")
	public Page<StudentDTO> getStudents(@RequestParam(required = false) String className,
			@RequestParam(required = false) String teacherFullName, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {

		Page<Student> students = studentService.getStudents(className, teacherFullName, PageRequest.of(page, size));

		return students.map(this::mapDTO);
	}

	private StudentDTO mapDTO(Student student) {
		StudentDTO studentdto = new StudentDTO();
		studentdto.setId(student.getId());
		studentdto.setFirstName(student.getFirstName());
		studentdto.setLastName(student.getLastName());
		if (student.getStudentClass() != null) {
			studentdto.setClassName(student.getStudentClass() == null ? null : student.getStudentClass().getName());
			studentdto.setTeacherFullName(student.getStudentClass().getTeacher() == null ? null
					: student.getStudentClass().getTeacher().getFirstName() + " "
							+ student.getStudentClass().getTeacher().getLastName());
		}
		return studentdto;
	}

	// http://localhost:8082/students/addStudent
	@PostMapping("/addStudent")
	@ResponseBody
	public Student addStudent(@RequestBody Student student) {
		return studentService.addstudent(student);
	}

}
