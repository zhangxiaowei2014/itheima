package com.zxw.itheima.optional;

import com.zxw.itheima.entity.Student;

import java.util.Optional;

public class OrElseThrowDemo {

    public static void getStudentInfo(Student student){

        Optional<Student> optionalStudent = Optional.ofNullable(student);

        try {
            Student student1 = optionalStudent.orElseThrow(MyException::new);
            System.out.println(student1);
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Student student = new Student(12, "xxx", 46);
        Student student1 = null;
        getStudentInfo(student1);
    }
}
