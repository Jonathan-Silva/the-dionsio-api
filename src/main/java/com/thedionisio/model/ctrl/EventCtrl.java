package com.thedionisio.model.ctrl;

import com.thedionisio.dao.EventRepository;
import com.thedionisio.model.bss.EventBss;
import com.thedionisio.model.dto.*;
import com.thedionisio.util.verification.Validation;
import org.bson.Document;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
                if (eventBss.existingValidation(collection, event))
                {
                    ResponseEntity responseEntity = eventRepository.create(collection, event.treatCreate());
                    try
                    {
                        if (Boolean.parseBoolean(responseEntity.getBody().toString()))
                        {
                           return this.find();
                        }
                    }
                    catch (Exception e)
                    {
                        return responseEntity;
                    }

                }
                return Validation.resquest.REGISTRY_EXISTED(event.attributeIdentifier() + event.name);
            }
            return Validation.resquest.NOT_CONTAINS_FIELDS(event.isRequired());
        }
        catch (Exception e)
        {
            return Validation.resquest.NOT_DATA_BASE();
        }

    }

    public Object find(){

        Object objectFind  = eventRepository.find(collection,new Event(), new Document(), new Document(),0);
        try
        {
            List<Event> events = (List<Event>) objectFind;
            return eventBss.treatResponse(events);
        }
        catch (Exception e)
        {
            return objectFind;
        }
    }

    public Object findBy(EventFilterFind eventFilterFind){
        Object objectFind  = eventRepository.find(collection,new Event(), eventFilterFind.getQueryDocument(), new Document(),0);
        try
        {
            List<Event> events = (List<Event>) objectFind;
            return eventBss.treatResponse(events);
        }
        catch (Exception e)
        {
            return objectFind;
        }
    }

    public Object findOne(Object id){
        Object objectFind  = eventRepository.findOne(collection,id,new Event());

        try
        {
            List<Event> events = (List<Event>) objectFind;
            return eventBss.treatResponse(events);
        }
        catch (Exception e)
        {
            return objectFind;
        }


    }

    public Object update(Event event){

        try
        {
            if(Validation.resquest.idValidation(event._id))
            {
                Object objectResponse = eventRepository.updateBlock(collection, event._id, event);
                try
                {
                    if((Boolean) objectResponse)
                    {
                        return Validation.resquest.REGISTRY_CREATE(event._id);
                    }
                }catch (Exception e)
                {
                    return objectResponse;
                }

            }
            return Validation.resquest.NOT_CONTAINS_ID();
        }
        catch (Exception e)
        {
            return Validation.resquest.NOT_DATA_BASE();
        }
    }

    public Object removeOne(Event event){
        return eventRepository.removeOne(event._id,collection);
    }

    public Object asd()
    {
        Event event = new Event();
        DateTimeRange dateTimeRange = new DateTimeRange();
        dateTimeRange.start = LocalDateTime.now();
        dateTimeRange.end = LocalDateTime.now();
        event._id = "59164e6565bd9015c466113c";
        event._idCompany = "59164e6565bd9015c466113c";
        Place place = new Place();
        place.answerable="José Toalha";
        place.description="CASA DA MAE JOANA";
        place.city="Soberanna do DDD18";
        place.street="Joao Dutra";
        place.number = "A5";
        place.phone = "(00) 0 0000 - 0000";
        Location location =  new Location();
        location.latitude="123.456";
        location.longitude="789.456";
        place.isActive = true;
        place.location = location;
        place.zipCode = "16012-625";
        event.place= place;
        event.dateTimeRange = dateTimeRange;
        event.name="Festa das PRIMA";
        event.description = "Só não pode dar bitoca, porque boca de puta é guaveta da de piroca";
        List<String> genres = new ArrayList<>();
        genres.add("genro 1");
        genres.add("genro 2");
        genres.add("genro 3");
        event.genres = genres;
        List<String> banners = new ArrayList<>();
        banners.add("url-banner 1");
        banners.add("url-banner 2");
        banners.add("url-banner 3");
        event.urlBanners=banners;
        List<Batch> batches = new ArrayList<>();
        Batch batch = new Batch();
        batch.name = "Um Sabio Qualquer";
        batch.dateTimeRange = dateTimeRange;
        batch.description ="Thor filho do Brasil";
        batch.limit =50;
        batch.sector = "NO CANTINHO";
        batch.sold =25;
        batch.isActive = true;
        Price price = new Price();
        price.man=15.0;
        price.woman=15.0;
        price.other=15.0;
        batch.price = price;
        OpenBar openBar = new OpenBar();
        openBar.description = "Você tem direto a um toddynho";
        openBar.name = "Patotinha";
        openBar.isActive = true;
        batch.openBar = openBar;
        batches.add(batch);
        event.batches =  batches;
        event.isActive = true;

        return event;
    }
}


