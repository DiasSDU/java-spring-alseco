package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByName(String name);

    @Query(value = "select * from spring_boot_db.user",nativeQuery = true)
    List<User> getMainPage();

}
