package com.thedionisio.model.bss;

import com.thedionisio.dao.PersonRepository;
import com.thedionisio.model.dto.Person;
import com.thedionisio.util.mongo.Mongo;
import com.thedionisio.util.verification.Description;
import org.bson.Document;
import java.util.List;

/**
 * Created by jonathan on 3/6/17.
 */
public class PersonBss {
    private PersonRepository personRepository = new PersonRepository();

    public Boolean existingValidation(Person person){
        try
        {
           List list = (List) personRepository.findByEmail(person.email);

            return list.size() <= 0;
        }
        catch (Exception e )
        {
           return null;
        }

    }

    public Document treatResponse(List<Person> people){
        people.forEach(p->{
            p._id = Mongo.treatMongoId.toString(p._id);
            p.password = Description.PASSWORD_SHADOW;
        });

        Document response = new Document();
        response.put("people", people);
        return response;
    }


}
