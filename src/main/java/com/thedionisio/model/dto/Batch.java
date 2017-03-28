package com.thedionisio.model.dto;

/**
 * Created by jonathan on 3/6/17.
 */
public class Batch {


    @Override
    public String toString() {
        return "Batch{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", sector='" + sector + '\'' +
                ", date=" + date +
                ", limit=" + limit +
                ", sold=" + sold +
                ", price=" + price +
                ", openBar=" + openBar +
                ", isActive=" + isActive +
                '}';
    }

    public Object _id;
    public String name;
    public String description;
    public String sector;
    public Date date;
    public Integer limit;
    public Integer sold;
    public Price price;
    public OpenBar openBar;
    public Boolean isActive;



}
