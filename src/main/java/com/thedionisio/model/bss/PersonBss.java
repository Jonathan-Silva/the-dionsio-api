package com.thedionisio.model.bss;

import com.thedionisio.dao.PersonRepository;
import com.thedionisio.model.dto.Person;
import com.thedionisio.security.Security;
import com.thedionisio.util.Util;
import com.thedionisio.util.validation.Description;
import org.bson.Document;
import java.util.List;

/**
 * Created by jonathan on 3/6/17.
 */
public class PersonBss {
    private PersonRepository personRepository = new PersonRepository();

    public Boolean createValidation(Person person){
        if(person.name!=null && person.email!=null && person.password!=null){
            return true;
        }
        return false;
    }

    public Boolean existingValidation(Person person){
        try
        {
           List list = (List) personRepository.findByEmail(person.email);

           if (list.size()>0){
               return false;
           }
           return true;
        }
        catch (Exception e )
        {
           return null;
        }

    }

    public Document treatResponse(List<Person> people){
        people.forEach(p->{
            p._id = Util.treatMongoId.toString(p._id);
            p.password = Description.password;
        });

        Document response = new Document();
        response.put("people", people);
        return response;
    }


}
