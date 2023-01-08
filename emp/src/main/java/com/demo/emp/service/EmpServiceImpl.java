package com.demo.emp.service;

import com.demo.emp.entity.Emp;
import com.demo.emp.exception.EmpException;
import com.demo.emp.repository.EmpRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpServiceImpl implements EmpService {

    Logger logger = LoggerFactory.getLogger(EmpServiceImpl.class);

    @Autowired
    EmpRepository empRepository;

    @Value("${com.myValue}")
    private String myProp;

    @Override
    public Emp getEmpById(Integer id) {

        logger.info("Service get emp details by Id:{}, myProp: {}  ",
                new Object[] {id,myProp});


        logger.debug("Service get emp details by Id:{} ",id);
        logger.info("Service get emp details by Id:{} ",id);
        logger.warn("Service get emp details by Id:{} ",id);
        logger.error("Service get emp details by Id:{} ",id);

        Optional<Emp> findById = empRepository.findById(id);

        return findById.get();

    }

    @Override
    public Emp addEmp(Emp emp) {

        String name = emp.getName();
        try {
            return empRepository.save(emp);
        }catch (Exception e) {
            logger.error("Error while add new Emp: {}",e);
            throw new EmpException("Error while add new Emp with invalid data.");
        }

    }

    @Override
    public Emp getEmpByName(String name) {

        return empRepository.findByName(name) ;
    }

    @Override
    public List<Emp> getAllEmp() {

        return empRepository.findAllEmp() ;
    }

}
