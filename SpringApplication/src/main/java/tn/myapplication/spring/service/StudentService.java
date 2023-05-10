package tn.myapplication.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import tn.myapplication.spring.entity.Student;
import tn.myapplication.spring.repository.StudentRepository;

@Service
public class StudentService {
	private final StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public Page<Student> getStudents(String className, String teacherFullName, Pageable pageable) {
		if (className == null && teacherFullName == null) {
			return studentRepository.findAll(pageable);
		} else if (className == null) {
			return studentRepository.findByTeacherFullName(teacherFullName, pageable);
		} else if (teacherFullName == null) {
			return studentRepository.findByClassName(className, pageable);
		} else {
			return studentRepository.findByClassNameAndTeacherFullName(className, teacherFullName, pageable);
		}
	}

	public Student addstudent(Student student) {
		studentRepository.save(student);
		return student;
	}

}
