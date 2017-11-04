package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	public User getById(Long id);

	@Query("SELECT u FROM User as u")
	public List<User> getAll();

	public List<User> getByFirstNameAndLastName(String firstName, String lastName);

}
