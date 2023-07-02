package com.job.future.jobservice.repository;

import com.job.future.jobservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

   Optional<User> findByUsername(String username);

   @Query(value = "SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM users u  WHERE u.username = ?1", nativeQuery = true)
   Boolean existsByUsername(String username);




}
