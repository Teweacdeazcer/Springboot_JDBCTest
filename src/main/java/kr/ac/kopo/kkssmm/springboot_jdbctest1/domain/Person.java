package kr.ac.kopo.kkssmm.springboot_jdbctest1.domain;

import lombok.Data;

@Data
public class Person {
    private int id;
    private String name;
    private int age;
    private String email;
}
