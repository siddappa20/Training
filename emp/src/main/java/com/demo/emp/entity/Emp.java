package com.demo.emp.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
@Table(name="Emp")
public class Emp {

    // @ID This annotation specifies
    // the primary key of the entity.


    // @GeneratedValue This annotation
    // is used to specify the primary
    // key generation strategy to use

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer salary;
    private String status = "A";

    public Emp() {
    }

    public Emp(Integer id, String name, Integer salary) {
        super();
        this.id = id;
        this.name = name;
        this.salary = salary;
    }


}
