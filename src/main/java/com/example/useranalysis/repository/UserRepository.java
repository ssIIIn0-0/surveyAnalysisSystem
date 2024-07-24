package com.example.useranalysis.repository;

import com.example.useranalysis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
