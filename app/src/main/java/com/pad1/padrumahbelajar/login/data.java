package com.pad1.padrumahbelajar.login;
import com.google.gson.annotations.SerializedName;

public class data {
    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    @SerializedName("role")
    private String role;

    @SerializedName("email")
    private String email;

    public String getUsername(){
        return username;
    }
    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

}
