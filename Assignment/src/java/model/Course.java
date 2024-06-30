/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author DUCDUY2003
 */
public class Course {

    private int id;
    private String name;
    private Lecturer lecturer;
    private Subject subject;
    private Semester semester;
    private ArrayList<Student> students = new ArrayList<>();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public Subject getSubject() {
        return subject;
    }

    public Semester getSemester() {
        return semester;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

}
