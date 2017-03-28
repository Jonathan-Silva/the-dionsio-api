package com.thedionisio.model.dto;
import com.thedionisio.security.Security;

import java.time.LocalDate;
import java.util.*;

/**
 * Created by jonathan on 2/25/17.
 */


public class Person {


    @Override
    public String toString() {
        return "Person{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", birth=" + birth +
                ", cpf='" + cpf + '\'' +
                ", sex='" + sex + '\'' +
                ", genres=" + genres +
                ", card=" + card +
                ", isActive=" + isActive +
                '}';
    }

    public Object _id;
    public String name;
    public String email;
    public String password;
    public LocalDate birth;
    public String cpf;
    public String sex;
    public List<String> genres;
    public List<Card> card;
    public Boolean isActive;



    public String isRequered(){
        return "< name, email, password >";
    }

    public Person treatCreate(){

        this.password = Security.encryption.generateHash(this.password);
        this.isActive = true;

        return this;
    }


}
