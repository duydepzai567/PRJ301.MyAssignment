/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DUCDUY2003
 */
public class Exam {

    private int id;
    private Date from;
    private int duration;
    private Assessment assessment;
    private ArrayList<Grades> grades = new ArrayList<>();

    public int getId() {
        return id;
    }

    public Date getFrom() {
        return from;
    }

    public int getDuration() {
        return duration;
    }

    public Assessment getAssessment() {
        return assessment;
    }

    public ArrayList<Grades> getGrades() {
        return grades;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }

    public void setGrades(ArrayList<Grades> grades) {
        this.grades = grades;
    }

    
}
