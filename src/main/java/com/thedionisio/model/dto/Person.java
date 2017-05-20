package com.thedionisio.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thedionisio.security.Security;
import com.thedionisio.util.mongo.Mongo;
import com.thedionisio.util.verification.Description;
import com.thedionisio.util.verification.Validation;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.swing.table.TableRowSorter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
                ", picture='" + picture + '\'' +
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
    public String picture;
    public String sex;
    public List<String> genres;
    public List<Card> card;
    public Boolean isActive;



    @JsonIgnore
    public String isRequered(){
        return "< name, email, password, genres, cpf >";
    }

    @JsonIgnore
    public Person treatCreate(){

        this.password = Security.encryption.generateHash(this.password);
        this.isActive = true;
        try
        {
            List<String> genresLowerCase = new ArrayList<>();
            this.genres.forEach(g->genresLowerCase.add(g.toLowerCase()));
            this.genres = genresLowerCase;
        }
        catch (Exception e)
        {
            System.out.println("log de erro genres");
        }

        return this;
    }

    @JsonIgnore
    public Boolean createValidation(){
     return this.name!=null  &&
            this.email!=null &&
            this.password!=null &&
            this.genres!=null &&
            Validation.document.isValidCPF(this.cpf);

    }

    public Person treatResponse(){
        this._id = Mongo.treatMongoId.toString(this._id);
        this.password = Description.PASSWORD_SHADOW;
        return  this;
    }

    @JsonIgnore
    public String attributeIdentifier(){return "email < ";}

    @JsonIgnore
    public String BCryptEncoderPassword() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(this.password);
    }

}
