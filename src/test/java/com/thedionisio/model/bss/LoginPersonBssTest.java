package com.thedionisio.model.bss;

import com.thedionisio.model.dto.Login;
import com.thedionisio.security.Security;
import com.thedionisio.util.UtilTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jonathan on 3/27/17.
 */
public class LoginPersonBssTest {

    @Before
    public void createPerson()
    {
        UtilTest.crudHelp.creatPerson();
    }

    @Test
    public void LoginPersonTest(){
       Login login = new Login();
       login.email="alan@turing.com";
       login.password="turing";
       login.entity="person";
       login = (Login) new LoginBss().makeLogin(login);

       assertEquals("5112fe4cc97ba26920a1d25f929ba0c23055241e",login.token);

    }

    @After
    public void deletePerson()
    {
        UtilTest.crudHelp.deletePerson();
    }

}
