package com.thedionisio.resources;

import com.thedionisio.model.ctrl.PersonCtrl;
import com.thedionisio.model.dto.Person;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jonathan on 2/25/17.
 */
@RestController
@RequestMapping(value = "/person")
public class PersonResource {

    private PersonCtrl personCtrl = new PersonCtrl();

    @RequestMapping(method = RequestMethod.GET)
    public Object get()  {return personCtrl.find();}

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    public Object getOne(@PathVariable Object id)  {
        //return com.thedionisio.util.verification.ValidationObject.document.isValidCPF(id.toString());
        return personCtrl.findOne(id);
    }


    @RequestMapping(method = RequestMethod.POST)
    public Object create(@RequestBody Person person)  {

        return this.personCtrl.create(person);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Object update(@RequestBody Person person) {

        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("nome: " + person.name);
        System.out.println("email: " + person.email);
        System.out.println("senha: " + person.password);
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        return this.personCtrl.update(person);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Object remove(@RequestBody Person person) {

        return this.personCtrl.removeOne(person);

    }



}
