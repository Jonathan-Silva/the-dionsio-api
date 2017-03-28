package com.thedionisio.resources;

import com.thedionisio.model.ctrl.LoginCtrl;
import com.thedionisio.model.dto.Login;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jonathan on 3/28/17.
 */
@RestController
@RequestMapping(value = "/login")
public class LoginResource {

    @RequestMapping(method = RequestMethod.POST)
    public Object makeLogin(@RequestBody Login login){
        return new LoginCtrl().makeLogin(login);
    }
}
