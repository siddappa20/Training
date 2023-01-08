package com.demo.emp.controller;

import com.demo.emp.domain.EmpResponse;
import com.demo.emp.entity.Emp;
import com.demo.emp.service.EmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {

    private final Logger logger = LoggerFactory.getLogger(EmpController.class);

    @Autowired
    private EmpService empService;

    @GetMapping("/emp/{id}")
    public ResponseEntity<EmpResponse> getEmp(@PathVariable("id") Integer id) {

        logger.debug("get emp details by Id:{} ",id);
        logger.info("get emp details by Id:{} ",id);
        logger.warn("get emp details by Id:{} ",id);
        logger.error("get emp details by Id:{} ",id);


        Emp emp = empService.getEmpById(id);
        EmpResponse res = new EmpResponse();
        res.setEmpRes(emp);
        res.setMessage("success");


        return new ResponseEntity<EmpResponse>(res, HttpStatus.OK);

    }

    @GetMapping("/empByName")
    public ResponseEntity<EmpResponse> getEmp(@RequestParam String name) {

        logger.debug("get emp details by name:{} ",name);


        Emp emp = empService.getEmpByName(name);
        EmpResponse res = new EmpResponse();
        res.setEmpRes(emp);
        res.setMessage("success");

        logger.debug("get emp details by name:{}, Emp:{} ",name,emp);



        return new ResponseEntity<EmpResponse>(res, HttpStatus.OK);

    }

    @GetMapping("/allEmp")
    public ResponseEntity<EmpResponse> getAllEmp() {

        List<Emp> empList = empService.getAllEmp();
        EmpResponse res = new EmpResponse();
        res.setEmpRes(empList);
        res.setMessage("success");

        return new ResponseEntity<EmpResponse>(res, HttpStatus.OK);

    }

    @PostMapping("/emp")
    public ResponseEntity<Object> addEmp(@RequestBody Emp emp) {

        EmpResponse res = new EmpResponse();
        if(emp == null) {
            return new ResponseEntity<Object>("Invalid employee", HttpStatus.BAD_REQUEST);
        }

        Emp	addEmp =  empService.addEmp(emp);

        res.setEmpRes(addEmp);
        res.setMessage("New employee added successfully");

        return new ResponseEntity<Object>(res, HttpStatus.OK);

    }

}

