package com.thedionisio.model.ctrl;

import com.thedionisio.dao.EventRepository;
import com.thedionisio.model.bss.EventBss;
import com.thedionisio.model.dto.Event;
import com.thedionisio.util.validation.Description;
import com.thedionisio.util.validation.RequestValidation;
import com.thedionisio.util.validation.Validation;
import org.bson.Document;

/**
 * Created by jonathan on 3/11/17.
 */
public class EventCtrl {

    private EventBss eventBss = new EventBss();
    private EventRepository eventRepository = new EventRepository();
    private final String collection  ="event";

    public Object create(Event event){

        try
        {
            if(event.createValidation())
            {
                if (eventBss.existingValidation(collection,event))
                {
                    return eventRepository.create(collection, event);
                }
                return Validation.resquest.registry_existed(event.attributeIdentifier() + event);
            }
            return Validation.resquest.not_contains_fields(event.isRequered());
        }
        catch (Exception e)
        {
            return Validation.resquest.not_data_base();
        }

    }

    public Object find(){
        return  eventRepository.find(collection,new Event(),new Document(), new Document());
    }

    public Object findOne(Object id){
        try
        {
            if(Validation.resquest.idValidation(id))
            {
                return eventRepository.findOne(collection,id, new Event());
            }
            return Validation.resquest.not_contains_id();
        }
        catch (Exception e)
        {
            return Validation.resquest.not_data_base();
        }
    }

    public Object update(Event event){
        try
        {
            if(Validation.resquest.idValidation(event._id))
            {
                return  eventRepository.update(collection, event._id, event);
            }
            return Validation.resquest.not_contains_id();
        }
        catch (Exception e)
        {
            return Validation.resquest.not_data_base();
        }
    }

    public Object remove(Event event){
        try
        {
            if(Validation.resquest.idValidation(event._id))
            {
                return eventRepository.removeOne(collection, event._id);
            }
            return Validation.resquest.not_contains_id();
        }
        catch (Exception e)
        {
            return Validation.resquest.not_data_base();
        }

    }
}


