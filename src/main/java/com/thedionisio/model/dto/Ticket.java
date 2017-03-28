package com.thedionisio.model.dto;

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
                ", purchaseDate='" + purchaseDate + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    public Object _id;
    public Object _idPerson;
    public Object _idBatch;
    public String purchaseDate;
    public Boolean isActive;
}
