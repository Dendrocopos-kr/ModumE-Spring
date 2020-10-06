package com.amolrang.modume.user;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.amolrang.modume.user.model.User;

public interface UserRepository extends Repository {
	  Optional<User> findByEmail(String email);
}