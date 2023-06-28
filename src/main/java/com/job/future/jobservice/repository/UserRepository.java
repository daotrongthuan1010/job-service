package com.job.future.jobservice.repository;

import com.job.future.jobservice.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    @Query(value = "SELECT username FROM jobservice.User ", nativeQuery = true)
    Optional<Users> findByUsername(String username);
}
