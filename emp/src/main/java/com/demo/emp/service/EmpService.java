package com.demo.emp.service;

import com.demo.emp.entity.Emp;

import java.util.List;

public interface EmpService {
    public Emp getEmpById(Integer id);

    public Emp getEmpByName(String name);

    public Emp addEmp(Emp emp);

    public List<Emp> getAllEmp();
}
