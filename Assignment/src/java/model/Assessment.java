/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DUCDUY2003
 */
public class Assessment {
    private int id;
    private String name;
    private float weight;
    private Subject subject;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    
    
}
