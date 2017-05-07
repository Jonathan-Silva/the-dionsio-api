package com.thedionisio.model.ctrl;

import com.thedionisio.dao.EventRepository;
import com.thedionisio.model.bss.EventBss;
import com.thedionisio.model.dto.Event;
import com.thedionisio.util.verification.Validation;
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
                return Validation.resquest.REGISTRY_EXISTED(event.attributeIdentifier() + event);
            }
            return Validation.resquest.NOT_CONTAINS_FIELDS(event.isRequered());
        }
        catch (Exception e)
        {
            return Validation.resquest.NOT_DATA_BASE();
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
            return Validation.resquest.NOT_CONTAINS_ID();
        }
        catch (Exception e)
        {
            return Validation.resquest.NOT_DATA_BASE();
        }
    }

    public Object update(Event event){
        try
        {
            if(Validation.resquest.idValidation(event._id))
            {
                return  eventRepository.update(collection, event._id, event);
            }
            return Validation.resquest.NOT_CONTAINS_ID();
        }
        catch (Exception e)
        {
            return Validation.resquest.NOT_DATA_BASE();
        }
    }

    public Object remove(Event event){
        try
        {
            if(Validation.resquest.idValidation(event._id))
            {
                return eventRepository.removeOne(collection, event._id);
            }
            return Validation.resquest.NOT_CONTAINS_ID();
        }
        catch (Exception e)
        {
            return Validation.resquest.NOT_DATA_BASE();
        }

    }
}


