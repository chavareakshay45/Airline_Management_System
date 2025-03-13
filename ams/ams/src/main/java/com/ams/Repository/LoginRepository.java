package com.ams.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ams.Model.User;

@Repository
public interface LoginRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}
