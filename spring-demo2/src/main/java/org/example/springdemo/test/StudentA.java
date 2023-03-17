package org.example.springdemo.test;

/**
 * @author liuliangqi
 * @date 2022/12/26 13:56
 */
public class StudentA {

    private StudentB studentB ;

    public void setStudentB(StudentB studentB) {
        this.studentB = studentB;
    }

    public StudentA() {
    }

    public StudentA(StudentB studentB) {
        this.studentB = studentB;
    }
}
