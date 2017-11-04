package com.example.demo.controller;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@RestController
public class DemoController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public @ResponseBody Response saveUser(@RequestBody User user) {
		return Response.status(Status.CREATED).entity(userRepository.save(user)).build();
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public @ResponseBody User getUserById(@PathVariable("id") Long id) {
		return userRepository.getById(id);
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public @ResponseBody List<User> getUsers() {
		return userRepository.getAll();
	}

	@RequestMapping(value = "/users/find", method = RequestMethod.GET)
	public @ResponseBody List<User> getUserByIdAndFirstName(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName) {
		return userRepository.getByFirstNameAndLastName(firstName, lastName);
	}
}
