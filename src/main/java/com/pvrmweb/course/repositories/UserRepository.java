package com.pvrmweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pvrmweb.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
