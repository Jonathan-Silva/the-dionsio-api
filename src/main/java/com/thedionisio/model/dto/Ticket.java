package com.thedionisio.model.dto;

import java.time.LocalDateTime;

/**
 * Created by jonathan on 3/7/17.
 */
public class Ticket {

    @Override
    public String toString() {
        return "Ticket{" +
                "_id=" + _id +
                ", _idPerson=" + _idPerson +
                ", _idBatch=" + _idBatch +
                ", purchaseDate=" + purchaseDate +
                ", price=" + price +
                ", openBar=" + openBar +
                ", isActive=" + isActive +
                '}';
    }

    public Object _id;
    public Object _idPerson;
    public Object _idBatch;
    public LocalDateTime purchaseDate;
    public Price price;
    public OpenBar openBar;
    public Boolean isActive;

}




