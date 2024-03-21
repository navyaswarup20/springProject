package com.social.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.website.modal.User;

public interface UserRepository extends JpaRepository<User, Integer> {
public User findByEmail(String email);
}
