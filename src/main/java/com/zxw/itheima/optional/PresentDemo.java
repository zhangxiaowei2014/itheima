package com.zxw.itheima.optional;

import com.zxw.itheima.entity.Student;

import java.util.Optional;

public class PresentDemo {

    public static void getStudentName(Student student){

        Optional<Student> optionalStudent = Optional.ofNullable(student);

        if (optionalStudent.isPresent()){
            System.out.println("student 不为null");
            System.out.println(optionalStudent);
        }else {
            System.out.println("student  为null");
        }
        optionalStudent.ifPresent(s -> System.out.println("student 不为null"));
        optionalStudent.ifPresent(s -> System.out.println(optionalStudent));
    }

    public static void main(String[] args) {
        Student su = new Student(12,"zxw", 24);
        getStudentName(su);
    }
}
