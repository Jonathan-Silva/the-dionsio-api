package com.thedionisio.dao;

import com.thedionisio.dao.mongoDB.MongoCrud;
import com.thedionisio.model.dto.Person;
import org.bson.Document;

/**
 * Created by jonathan on 3/8/17.
 */
public class PersonRepository extends SimpleCrudRepository{

    private MongoCrud mongoCrud = new MongoCrud();
    private Document query;
    private final String collection ="person";

    public Object findByEmail(String email)
    {
        query = new Document();
        query.put("email",email);
        return mongoCrud.find(collection,new Person(),query,new Document(),0);
    }

}
