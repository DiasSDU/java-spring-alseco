package com.example.demo.repository;

import com.example.demo.model.todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface todoRepository extends CrudRepository<todo,Long> {

}
