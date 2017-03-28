package com.thedionisio.util.mongo;

/**
 * Created by jonathan on 3/21/17.
 */
public class TreatMongoId {

    public String toString(Object id){
        return id.toString().replace("{$oid=","").replace("}","");
    }

}
