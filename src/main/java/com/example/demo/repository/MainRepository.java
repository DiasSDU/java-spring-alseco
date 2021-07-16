package com.example.demo.repository;

import com.example.demo.model.Main;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MainRepository extends JpaRepository<Main,Long> {


    @Query(value = "select id,name ,count(*) as count,sum(sum) as sum from spring_boot_db.user group by name",nativeQuery = true)
    List<Main> getMainPage(Pageable pageable);

}
