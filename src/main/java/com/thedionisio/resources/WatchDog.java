package com.thedionisio.resources;

import com.thedionisio.model.dto.Authentication;
import com.thedionisio.model.dto.Token;
import com.thedionisio.security.TokenManage;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jonathan on 4/11/17.
 */
@RestController()
public class WatchDog {


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Token test()
    {
        Authentication authentication = new Authentication();
        authentication.password="asade";
        authentication.email="jonathan@mail.com";
        Token token =  new Token();
        return new TokenManage().createToken(authentication);
    }
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public Authentication token(@RequestBody Token token)
    {
        if (new TokenManage().checkToken(token.hash))
        {
            return  new TokenManage().getAuthentication(token.hash);
        }
        return  null;
    }
}
