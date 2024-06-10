/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DUCDUY2003
 */
public class User {


    private String username;
    private String Password;
    private String displayname;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return Password;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setUsername(String Username) {
        this.username = Username;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }
}
