package com.job.future.jobservice.repository;

import com.job.future.jobservice.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @EntityGraph(value = "UserComplete", type = EntityGraphType.FETCH)
    Optional<User> findByUsername(String username);
    User findByEmail(String email);
    @Query(value="SELECT u.id, u.email, u.ho_ten FROM quanly.user u where u.ho_ten like :name or u.email = :name", nativeQuery = true)
    List<Map<String, Object>> findAllUserByHoTenorEmail(String name);

}
