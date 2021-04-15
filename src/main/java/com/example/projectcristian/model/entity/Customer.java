package com.example.projectcristian.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = " Cristian no te acepta ese dato!")
    private String fname;

    @NotEmpty(message = " este campo no deberia estar vacío!")
    private String lname;


    private static final long serialVersionUID = 1L;
}
