package tn.myapplication.spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import tn.myapplication.spring.entity.Class;

public interface ClassRepository extends JpaRepository<Class, Long> {

}
