package com.thedionisio.model.bss;

import com.thedionisio.model.dto.Person;
import org.bson.Document;

import java.util.List;

/**
 * Created by jonathan on 3/6/17.
 */
public class PersonBss {
    private CommonPersonCompanyBss commonPersonCompanyBss = new CommonPersonCompanyBss();

    public Boolean existingValidation(Person person){
        try
        {
            return commonPersonCompanyBss.existingValidation(person.email);
        }
        catch (Exception e )
        {
           return null;
        }

    }

    public Document treatResponse(List<Person> people){
        people.forEach(p->{
            p.treatResponse();
        });

        Document response = new Document();
        response.put("people", people);
        return response;
    }


}
