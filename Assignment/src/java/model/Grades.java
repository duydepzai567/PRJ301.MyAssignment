/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DUCDUY2003
 */
public class Grades {

    private Exam exam;
    private Student student;
    private float score;

    public Exam getExam() {
        return exam;
    }

    public Student getStudent() {
        return student;
    }

    public float getScore() {
        return score;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setScore(float score) {
        this.score = score;
    }
    
    
}
