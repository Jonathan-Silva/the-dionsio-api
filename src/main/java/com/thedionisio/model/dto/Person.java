package com.thedionisio.model.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thedionisio.security.Security;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;
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



    @JsonIgnore
    public String isRequered(){
        return "< name, email, password, genres >";
    }

    @JsonIgnore
    public Person treatCreate(){

        this.password = Security.encryption.generateHash(this.password);
        this.isActive = true;

        return this;
    }

    @JsonIgnore
    public Boolean createValidation(){
     return this.name!=null  &&
            this.email!=null &&
            this.password!=null &&
            this.genres!=null;
    }

    @JsonIgnore
    public String attributeIdentifier(){return "email < ";}

    @JsonIgnore
    public String BCryptEncoderPassword() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(this.password);
    }

}
