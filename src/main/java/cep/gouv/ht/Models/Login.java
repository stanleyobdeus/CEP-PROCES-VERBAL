package cep.gouv.ht.Models;

import java.io.File;
import java.io.Serializable;

public class Login implements Serializable {
    private String Username;
    private String password;
    private String picture;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
