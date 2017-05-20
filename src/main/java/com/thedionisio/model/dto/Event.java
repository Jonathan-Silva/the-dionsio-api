package com.thedionisio.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thedionisio.security.Security;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * Created by jonathan on 3/6/17.
 */
public class Event {


    @Override
    public String toString() {
        return "Event{" +
                "_id=" + _id +
                ", _idCompany=" + _idCompany +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateTimeControl=" + dateTimeControl +
                ", genres=" + genres +
                ", urlBanners=" + urlBanners +
                ", batches=" + batches +
                ", tickets=" + tickets +
                ", place=" + place +
                ", isActive=" + isActive +
                '}';
    }

    public Object _id;
    public Object _idCompany;
    public String name;
    public String description;
    public DateTimeControl dateTimeControl;
    public List<String> genres;
    public List<String> urlBanners;
    public List<Batch> batches;
    @JsonIgnore()
    public List<Ticket> tickets;
    public Place place;
    public Boolean isActive;


    @JsonIgnore
    public Event treatCreate(){
        this._idCompany = new ObjectId(_idCompany.toString());
        this.isActive = true;

        return this;
    }

    @JsonIgnore()
    public String isRequered(){
        return " < _idCompany, _idPlace, name >";
    }
    @JsonIgnore()
    public Boolean createValidation(){
        return  this.name!=null;
    }
    @JsonIgnore()
    public String attributeIdentifier(){return "email < ";}

}
