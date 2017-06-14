package com.thedionisio.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thedionisio.util.mongo.Mongo;

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
                ", _idCompany=" + _idCompany +
                ", _idEvent=" + _idEvent +
                ", batch=" + batch +
                ", purchaseDate=" + purchaseDate +
                ", price=" + price +
                ", openBar=" + openBar +
                ", isActive=" + isActive +
                '}';
    }

    public Object _id;
    public Object _idPerson;
    public Object _idCompany;
    public Object _idEvent;
    public Batch batch;
    public LocalDateTime purchaseDate;
    public Price price;
    public OpenBar openBar;
    public Boolean isActive;

    public boolean createValidation() {
        return this._idCompany != null &&
               this._idPerson != null &&
               this._idEvent != null &&
               this.batch != null &&
               !this._idCompany.equals("")&&
               !this._idPerson.equals("")&&
               !this._idEvent.equals("");
    }

    @JsonIgnore
    public Ticket treatCreate() {
        this.isActive = true;
        this._id = null;
        this.purchaseDate = LocalDateTime.now();
        return this;
    }

    @JsonIgnore
    public String isRequiredForCreate() {
        return " < _idCompany, _idPerson, batch >";
    }

    @JsonIgnore
    public String attributeIdentifier(){return " _id < ";}

    @JsonIgnore
    public boolean updateValidation() {
        //valida update
        return true;
    }

    @JsonIgnore
    public Boolean treatUpdate() {
        //trata updade
        return true;
    }

    @JsonIgnore
    public Ticket treatResponse() {
        this._id = Mongo.treatMongoId.toString(this._id);
        return this;
    }

    @JsonIgnore
    public String isImmutable() {
        return " < _idCompany, _idPerson >";
    }
}




