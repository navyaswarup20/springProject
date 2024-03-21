package com.social.website.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.website.modal.User;
import com.social.website.repository.UserRepository;

//this is business class logic

@Service
public class UserServiceImplementation implements UserService{

	@Autowired
	UserRepository userRepository;
	@Override
	public User registerUser(User user) {
		User newUser=new User();
		newUser.setEmail(user.getEmail());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setPassword(user.getPassword());
		newUser.setId(user.getId()); 
		
		User savedUser=userRepository.save(newUser);
		return savedUser;
	}      

	@Override
	public User findUserById(Integer userId) throws Exception {
		Optional<User> user1=userRepository.findById(userId);
		if(user1.isPresent()) {
			return user1.get();
		}
	throw new Exception("User not found with this id: "+ userId);	
	}

	@Override
	public User findUserByEmail(String email) {
		User user=userRepository.findByEmail(email);
		return user;
	}

	@Override
	public User followUser(Integer userId1, Integer userId2) throws Exception {
		User user1=findUserById(userId1);
		User user2=findUserById(userId2);
		user2.getFollowers().add(user1.getId());
		return user1;
		
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> searchUser(String query) {
		// TODO Auto-generated method stub
		return null;
	}

}
