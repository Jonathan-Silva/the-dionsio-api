package com.thedionisio.dao;

import com.thedionisio.model.dto.Ticket;

import java.util.List;

/**
 * Created by jonathan on 6/12/17.
 */
public class TicketRepository extends SimpleCrudRepository {
    public Object treatResponse(List<Ticket> tickets) {
        return tickets;
    }
}
