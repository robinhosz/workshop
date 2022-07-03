package com.spring.workshop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static  final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String email;

}
