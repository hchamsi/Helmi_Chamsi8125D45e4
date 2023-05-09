package tn.myapplication.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.myapplication.spring.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
