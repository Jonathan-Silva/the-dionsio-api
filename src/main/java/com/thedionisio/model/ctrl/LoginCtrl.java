package com.thedionisio.model.ctrl;

import com.thedionisio.model.bss.LoginBss;
import com.thedionisio.model.dto.Login;
import com.thedionisio.util.validation.Validation;

/**
 * Created by jonathan on 3/26/17.
 */
public class LoginCtrl {
    private LoginBss loginBss= new LoginBss();

    public Object makeLogin(Login login)
    {
        if (login.isValid()==1)
        {
            Object objectResponse = loginBss.makeLogin(login);
            try
            {
                return objectResponse;
            }
            catch (Exception e)
            {
                return  objectResponse;
            }
        }
        return Validation.resquest.not_contains_fields(login.isRequed());
    }
}
