package com.thedionisio.model.ctrl;

import com.thedionisio.dao.PersonRepository;
import com.thedionisio.model.bss.PersonBss;
import com.thedionisio.model.dto.Person;
import com.thedionisio.util.mongo.Mongo;
import com.thedionisio.util.validation.Validation;
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
                  try
                  {
                      if (Boolean.parseBoolean(responseEntity.getBody().toString()))
                      {
                        List<Person> people = (List<Person>) personRepository.findByEmail(person.email);
                        Object personResponse = Mongo.treatMongoId.toString(people.get(0)._id);
                        return Validation.resquest.registry_create(personResponse);
                      }
                  }
                  catch (Exception e)
                  {
                      return responseEntity;
                  }

              }
              return Validation.resquest.registry_existed(person.attributeIdentifier() + person.email);
            }
            return Validation.resquest.not_contains_fields(person.isRequered());
        }
        catch (Exception e)
        {
            return Validation.resquest.not_data_base();
        }

    }

    public Object find(){

        Object objectResponse = personRepository.find(collection,new Person(), new Document(), new Document());

        try
        {
            ResponseEntity<Object> responseEntity = (ResponseEntity<Object>) objectResponse;
            List<Person> person = (List<Person>) responseEntity.getBody();
            return personBss.treatResponse(person);
        }
        catch (Exception e)
        {
            return objectResponse;
        }
    }

    public Object findOne(Object id){
        try
        {
            if(Validation.resquest.idValidation(id))
            {
                Object objectResponse = personRepository.findOne(collection,id, new Person());
                ResponseEntity<Object> responseEntity = (ResponseEntity<Object>) objectResponse;
                List<Person> person = (List<Person>) responseEntity.getBody();
                return personBss.treatResponse(person);
            }
            return Validation.resquest.not_contains_id();
        }
        catch (Exception e)
        {
            return Validation.resquest.not_data_base();
        }
    }

    public Object update(Person person){

       try
       {
           if(Validation.resquest.idValidation(person._id))
           {
               Object objectResponse = personRepository.update(collection, person._id, person);
              try
              {
                  if((Boolean) objectResponse)
                  {
                      return Validation.resquest.registry_create(person._id);
                  }
              }catch (Exception e)
              {
                  return objectResponse;
              }

           }
           return Validation.resquest.not_contains_id();
       }
       catch (Exception e)
       {
           return Validation.resquest.not_data_base();
       }
    }

    public Object remove(Person person){
       try
       {
           if(Validation.resquest.idValidation(person._id))
           {
               Object objectResponse = personRepository.removeOne(collection, person._id);

               ResponseEntity<Object> responseEntity = (ResponseEntity<Object>) objectResponse;

               try
               {
                    if ((Boolean)responseEntity.getBody())
                    {
                        return  Validation.resquest.registry_deleted(person._id);
                    }
               }
               catch (Exception e)
               {
                   return responseEntity;
               }
           }
           return Validation.resquest.not_contains_id();
       }
       catch (Exception e)
       {
           return Validation.resquest.not_data_base();
       }

    }
}
