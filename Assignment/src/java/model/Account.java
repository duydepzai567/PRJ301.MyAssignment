/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DUCDUY2003
 */
public class Account {
    private String username;
    private String password;
    private String displayname;
    private Lecturer lecturer;
    private Student student;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDisplayname() {
        return displayname;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public Student getStudent() {
        return student;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    

}
