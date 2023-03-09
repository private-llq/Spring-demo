package org.example.springdemo.test;

/**
 * @author liuliangqi
 * @date 2022/12/26 13:57
 */
public class StudentB {

    private StudentC studentC ;

    public void setStudentC(StudentC studentC) {
        this.studentC = studentC;
    }

    public StudentB() {
    }

    public StudentB(StudentC studentC) {
        this.studentC = studentC;
    }
}
