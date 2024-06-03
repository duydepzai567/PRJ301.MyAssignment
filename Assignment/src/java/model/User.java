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
    private String Username;
    private String Password;
    private String displayname;

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public User(String Username, String Password, String displayname) {
        this.Username = Username;
        this.Password = Password;
        this.displayname = displayname;
    }
    
    
}
