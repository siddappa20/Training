package com.demo.emp.repository;

import com.demo.emp.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Integer> {

    public Emp findByName(String string);

    //@Query(value="SELECT id,name,salary,status FROM Emp", nativeQuery = true) // SQL
    @Query(value="FROM Emp") // HQL
    public List<Emp> findAllEmp();
}
