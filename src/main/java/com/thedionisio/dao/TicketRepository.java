package com.thedionisio.dao;

import com.thedionisio.model.dto.Ticket;
import org.bson.Document;

import java.util.List;

/**
 * Created by jonathan on 6/12/17.
 */
public class TicketRepository extends SimpleCrudRepository {

    private final String collection  ="ticket";

    public Object treatResponse(List<Ticket> tickets) {
        return tickets;
    }

    public Object findAfterCreate(Ticket ticket) {

        Document query = new Document();
        query.put("_idEvent",ticket._idEvent);
        query.put("_idPerson",ticket._idPerson);
        query.put("_idCompany",ticket._idCompany);

        Object objectFind  = super.find(collection,new Ticket(), query, new Document(),0);
        try
        {
            List<Ticket> tickets = (List<Ticket>) objectFind;
            return tickets.get(0).treatResponse();
        }
        catch (Exception e)
        {
            return objectFind;
        }

    }
}
