package com.social.website.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.social.website.modal.User;
import com.social.website.repository.UserRepository;
import com.social.website.services.UserService;


@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/addUser")
	   public User addUser(@RequestBody User user) {
			User savedUser=userService.registerUser(user);
		return savedUser;
			
		}
	
	@GetMapping("/UserController")
	public List<User> homeControllerHandler() {
		List<User> users=userRepository.findAll();
		return users;
		
	}
	@PutMapping("/updateUser/{userId}")
	public User getUserById(@RequestBody User user, @PathVariable("userId") Integer id) throws Exception {
	
		Optional<User> user1=userRepository.findById(id);
		if(user1.isEmpty()) {
			throw new Exception("User not found");
		}
		
		User oldUser=user1.get();
		if(user.getFirstName() != null ) {
			 oldUser.setFirstName(user.getFirstName());
		}
		if(user.getLastName() != null ) {
			 oldUser.setLastName(user.getLastName());
		}
		if(user.getEmail() != null ) {
			 oldUser.setEmail(user.getEmail());
		}
		User updateUser=userRepository.save(oldUser);
		return  updateUser;
	}
	
	@GetMapping("/UserController/{userId}")
	public User getUserById(@PathVariable("userId") int id) throws Exception {
User user=userService.findUserById(id);	
return user;
	}

	

	
	@DeleteMapping("/deleteUser/{userId}")
	public String deleteUserById(@PathVariable("userId") int id) throws Exception {
		Optional<User> user=userRepository.findById(id);
		if(user.isEmpty()) {
			throw new Exception("User not exist with this id: "+id);
		}
		
		userRepository.delete(user.get());
		return "User successfully deleted with this userId: "+id;
	}
}
