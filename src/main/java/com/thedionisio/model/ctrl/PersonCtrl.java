package com.thedionisio.model.ctrl;

import com.thedionisio.dao.PersonRepository;
import com.thedionisio.model.bss.PersonBss;
import com.thedionisio.model.dto.Company;
import com.thedionisio.model.dto.Person;
import com.thedionisio.util.mongo.Mongo;
import com.thedionisio.util.verification.Validation;
import org.bson.Document;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by jonathan on 3/2/17.
 */

public class PersonCtrl {

    private PersonBss personBss = new PersonBss();
    private PersonRepository personRepository = new PersonRepository();
    private final String collection  ="person";

    public Object create(Person person){

        try
        {
            if(person.createValidation())
            {
              if (personBss.existingValidation(person))
              {
                  ResponseEntity responseEntity = personRepository.create(collection, person.treatCreate());
                  try                  {
                      if (Boolean.parseBoolean(responseEntity.getBody().toString()))
                      {
                        List<Person> people = (List<Person>) personRepository.findByEmail(person.email);
                        Object personResponse = Mongo.treatMongoId.toString(people.get(0)._id);
                        return Validation.resquest.REGISTRY_CREATE(personResponse);
                      }
                  }
                  catch (Exception e)
                  {
                      return responseEntity;
                  }

              }
              return Validation.resquest.REGISTRY_EXISTED(person.attributeIdentifier() + person.email);
            }
            return Validation.resquest.NOT_CONTAINS_FIELDS(person.isRequered());
        }
        catch (Exception e)
        {
            return Validation.resquest.NOT_DATA_BASE();
        }

    }

    public Object find(){

        Object objectFind  = personRepository.find(collection,new Person(), new Document(), new Document(),0);
        try
        {
            List<Person> events = (List<Person>) objectFind;
            return personBss.treatResponse(events);
        }
        catch (Exception e)
        {
            return objectFind;
        }

    }

    public Object findOne(Object id){
        Object objectFind  = personRepository.findOne(collection,id,new Person());
        try
        {
            List<Person> events = (List<Person>) objectFind;
            return personBss.treatResponse(events);
        }
        catch (Exception e)
        {
            return objectFind;
        }
    }

    public Object update(Person person){
        return personRepository.update(person,person._id,collection);

    }

    public Object removeOne(Person person){
        return  personRepository.removeOne(person._id,collection);
    }
}
