package com.thedionisio.model.bss;

import com.thedionisio.dao.PersonRepository;
import com.thedionisio.model.dto.Login;
import com.thedionisio.model.dto.Person;
import com.thedionisio.security.Security;

import java.util.List;

/**
 * Created by jonathan on 3/26/17.
 */
public class LoginBss {

    public Boolean isValid(Login login)
    {
        if (!login.email.equals(null)    &&
            !login.email.equals("")      &&
            !login.password.equals(null) &&
            !login.password.equals("")   &&
            !login.entity.equals(null)   &&
            !login.entity.equals(""))
        {
            return true;
        }
        return false;
    }

    public Object makeLogin(Login login)
    {
        switch (login.entity)
        {
            case "person":
                return login;
            case "company":
                return login;
            default :
                return  login;
        }
    }

    public Object makeLoginPeopple(Login login)
    {
       Object reponse = new PersonRepository().findByEmail(login.email);
       try
       {
           List<Person> person = (List<Person>) reponse;
           if (Security.encryption.isPasswordValid(person.get(0).password,login.password))
           {
               //makeLogin

               login.token="ok";
               System.out.println("ok");
           }
           else
           {
               login.token="fail";
               //retorna erro de senha
               System.out.println("fail");
           }
           return  login;
       }
       catch (Exception e)
       {
            return reponse;
       }
    }

    public Login makeLoginCompany(Login login)
    {
       return  login;
    }

}
