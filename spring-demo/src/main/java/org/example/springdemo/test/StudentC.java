package org.example.springdemo.test;

/**
 * @author liuliangqi
 * @date 2022/12/26 13:57
 */
public class StudentC {

    private StudentA studentA ;

    public void setStudentA(StudentA studentA) {
        this.studentA = studentA;
    }

    public StudentC() {
    }

    public StudentC(StudentA studentA) {
        this.studentA = studentA;
    }
}
