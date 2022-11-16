package com.example.ivory.models;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="salaries")
public class Salary {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "employee_code")
    private int employee_code;


    @Column(name = "month")
    private String month;

    @Column(name = "gross")
    private String gross;

    @Column(name = "tax")
    private String tax;

    @Column(name = "total")
    private String total;


}
