package com.thedionisio.model.dto;

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
                ", password='" + password + '\'' +
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

}
