package com.thedionisio.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thedionisio.security.Security;
import com.thedionisio.util.mongo.Mongo;
import com.thedionisio.util.verification.Description;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

/**
 * Created by jonathan on 3/6/17.
 */
public class Company {
    @Override
    public String toString() {
        return "Company{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", socialName='" + socialName + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", email='" + email + '\'' +
                ", PASSWORD_SHADOW='" + password + '\'' +
                ", answerable='" + answerable + '\'' +
                ", phone='" + phone + '\'' +
                ", places=" + places +
                ", isActive=" + isActive +
                '}';
    }

    public Object _id;
    public String name;
    public String socialName;
    public String cnpj;
    public String email;
    public String password;
    public String answerable;
    public String phone;
    public List<Place> places;
    public Boolean isActive;

    @JsonIgnore
    public String isRequired(){
        return "< name, email, password, cnpj >";
    }

    @JsonIgnore
    public Company treatCreate(){
        this.password = Security.encryption.generateHash(this.password);
        this.isActive = true;

        return this;
    }
    @JsonIgnore
    public Boolean createValidation(){
        return  this.name!=null  &&
                this.email!=null &&
                this.password!=null &&
                this.cnpj!=null ;
        //&& Validation.document.isCNPJ(this.cnpj)
    }
    @JsonIgnore
    public String attributeIdentifier(){return "email < ";}

    @JsonIgnore
    public String BCryptEncoderPassword() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(this.password);
    }

    public Company treatResponse (){
        this._id = Mongo.treatMongoId.toString(this._id);
        this.password = Description.PASSWORD_SHADOW;
        return this;
    }

}
