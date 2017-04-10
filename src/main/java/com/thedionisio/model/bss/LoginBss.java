package com.thedionisio.model.bss;

import com.thedionisio.dao.PersonRepository;
import com.thedionisio.model.dto.Login;
import com.thedionisio.model.dto.Person;
import com.thedionisio.security.Encryption;
import com.thedionisio.security.Security;

import java.util.List;

/**
 * Created by jonathan on 3/26/17.
 */
public class LoginBss {


    public Object makeLogin(Login login)
    {
        switch (login.entity)
        {
            case "person":
                return makeLoginPeopple(login);
            case "company":
                return makeLoginCompany(login);
            default :
                return  login;
        }
    }

    private Object makeLoginPeopple(Login login)
    {
       Object reponse = new PersonRepository().findByEmail(login.email);
       try
       {
           List<Person> person = (List<Person>) reponse;

           if (person.size()>0 && Security.encryption.isPasswordValid(person.get(0).password,login.password))
           {
               login.token=Security.encryption.generateHash("you shall not pass");
           }
           else
           {
               login.token="fail";
           }


           return  login.treatResponse();
       }
       catch (Exception e)
       {
            return reponse;
       }
    }

    private Login makeLoginCompany(Login login)
    {
       return  login;
    }

}
