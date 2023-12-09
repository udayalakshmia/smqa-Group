package com.mcqa.repository;

import com.mcqa.bean.RoleType;
import com.mcqa.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmailAndPassword(String email, String password);

    List<User> findAllByRole(RoleType roleType);

    List<User> findByEmail(String email);
}
