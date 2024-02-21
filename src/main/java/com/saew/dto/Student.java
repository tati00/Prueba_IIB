package com.saew.dto;

public class Student {
    private int id;
    private String name;
    private String correo;
    private Float gpa;
    public Student(int id, String name, String correo, Float gpa) {
        this.id = id;
        this.name = name;
        this.correo = correo;
        this.gpa = gpa;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}


