package com.thedionisio.model.dto;

/**
 * Created by jonathan on 3/26/17.
 */
public class Login {


    @Override
    public String toString() {
        return "Login{" +
                "_id=" + _id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                ", entity='" + entity + '\'' +
                '}';
    }

    public Object _id;
    public String email;
    public String password;
    public String token;
    public String entity;


}
