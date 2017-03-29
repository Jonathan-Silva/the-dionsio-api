package com.thedionisio.model.bss;

import com.thedionisio.dao.PersonRepository;
import com.thedionisio.model.dto.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonathan on 3/6/17.
 */
public class EventBss {
    private PersonRepository personRepository = new PersonRepository();



    public Boolean existingValidation(String collection, Event event){
        try
        {
           List list = new ArrayList();

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


}
