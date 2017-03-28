package com.thedionisio.model.dto;

import com.thedionisio.util.validation.Description;

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

    public String isRequed()
    {
        return " <email, password, entity> ";
    }

    public Integer isValid()
    {
        try
        {

            if (!this.email.equals(null)    &&
                    !this.email.equals("")      &&
                    !this.password.equals(null) &&
                    !this.password.equals("")   &&
                    !this.entity.equals(null)   &&
                    !this.entity.equals(""))
            {
                return 1;
            }
            return 0;
        }
        catch (Exception e)
        {
            return 0;
        }
    }

    public Login treatResponse()
    {
        this.password = Description.password;
        return  this;
    }


}
