package com.thedionisio.model.ctrl;

import com.thedionisio.model.bss.LoginBss;
import com.thedionisio.model.dto.Login;

/**
 * Created by jonathan on 3/26/17.
 */
public class LoginCtrl {
    private LoginBss loginBss= new LoginBss();
    public Login makeLogin(Login login)
    {
        if (loginBss.isValid(login))
        {

        }
        return  login;
    }
}
