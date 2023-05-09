package tn.myapplication.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.myapplication.spring.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username); // Authentification

	Boolean existsByUsername(String username); // subscribe

	Boolean existsByEmail(String email); // subscribe

}
