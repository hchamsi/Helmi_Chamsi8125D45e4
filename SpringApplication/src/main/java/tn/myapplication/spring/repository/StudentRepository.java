package tn.myapplication.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.myapplication.spring.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {

	@Query("SELECT s FROM Student s JOIN Class c JOIN Teacher t WHERE c.name = :className AND  CONCAT(t.firstName, ' ', t.lastName) = :teacherFullName")
	Page<Student> findByClassNameAndTeacherFullName(@Param("className") String className, @Param("teacherFullName") String teacherFullName, Pageable pageable);

	@Query("SELECT s FROM Student s JOIN Class c JOIN Teacher t where CONCAT(t.firstName, ' ', t.lastName) = :teacherFullName")
	Page<Student> findByTeacherFullName(String teacherFullName, Pageable pageable);

	@Query("SELECT s FROM Student s JOIN Class c on s.studentClass = c.id where c.name = :className")
	Page<Student> findByClassName(@Param("className")String className, Pageable pageable);
}
