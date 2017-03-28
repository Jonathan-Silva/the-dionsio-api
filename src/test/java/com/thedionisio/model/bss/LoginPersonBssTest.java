package com.thedionisio.model.bss;

import com.thedionisio.model.dto.Login;
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
       login = (Login) new LoginBss().makeLoginPeopple(login);

       assertEquals("ok",login.token);

    }

    @After
    public void deletePerson()
    {
        UtilTest.crudHelp.deletePerson();
    }

}
