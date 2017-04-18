package com.thedionisio.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.thedionisio.model.dto.Authentication;
import com.thedionisio.model.dto.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jonathan on 4/11/17.
 */
public class TokenManage {
    private final String secret = "vicodin";

    public Token createToken(Authentication authentication)
    {
        Token token = null;
        try
        {
            token = new Token();
            Algorithm algorithm = Algorithm.HMAC256(secret);
            token.hash= JWT.create()
                           .withIssuer("auth0")
                           .withClaim("name",authentication.name)
                           .withClaim("email",authentication.email)
                           .withClaim("password",authentication.password)
                           .sign(algorithm);
        }
        catch (UnsupportedEncodingException exception)
        {
            //UTF-8 encoding not supported
        }
        catch (JWTCreationException exception)
        {
            //Invalid Signing configuration / Couldn't convert Claims.
        }
        finally
        {
            return  token;
        }
    }

    public Boolean checkToken(String token)
    {
        try
        {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                                      .withIssuer("auth0")
                                      .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        }
        catch (UnsupportedEncodingException exception)
        {
            //UTF-8 encoding not supported
        }
        catch (JWTVerificationException exception)
        {
            //Invalid signature/claims
        }
        return false;
    }


    public Authentication getAuthentication(String token)
    {
        try
        {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                                      .withIssuer("auth0")
                                      .build();
            DecodedJWT jwt = verifier.verify(token);
            Authentication authentication = new Authentication();
            authentication.name = jwt.getClaim("name").asString();
            authentication.email = jwt.getClaim("email").asString();
            authentication.password = jwt.getClaim("password").asString();
            return  authentication;

        }
        catch (UnsupportedEncodingException exception)
        {
            //UTF-8 encoding not supported
        }
        catch (JWTVerificationException exception)
        {
            //Invalid signature/claims
        }
        return null;
    }





}
