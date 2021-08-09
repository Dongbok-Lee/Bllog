package com.bok.bllog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bok.bllog.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
