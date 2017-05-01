package com.thedionisio.dao;

import com.thedionisio.dao.mongoDB.MongoCrud;
import com.thedionisio.util.verification.RequestValidation;
import org.bson.Document;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by jonathan on 3/3/17.
 */
public class SimpleCrudRepository {
    RequestValidation validation = new RequestValidation();


    private MongoCrud simpleCrud = new MongoCrud();

    public ResponseEntity create(String collection, Object object){

        if(simpleCrud.create(collection, object))
        {
            return validation.that_ok(true);
        }
        return validation.not_data_base();
    }

    public Object find(String collection, Object object, Document query, Document sort){

        Object result = simpleCrud.find(collection, object, new Document(), new Document(), 0);

        if(result != null)
        {
            return findRule(result);
        }
        return validation.not_data_base();
    }

    public Object findOne(String collection, Object id, Object object){

        Object result = simpleCrud.findOne(collection,id,object);

        if(result != null)
        {
            return findRule(result);
        }
        return validation.not_data_base();
      }

    public Object update(String collection, Object id, Object object){

        Object item = simpleCrud.update(collection,id,object);
        if(item != null)
        {
            if (!item.equals(false))
            {
                return true;
            }
            return  validation.item_not_found(item);
        }
        return validation.not_data_base();
    }

    public Object removeOne(String collection, Object id){

        Object result = simpleCrud.removeOne(collection,id);

        if (result!=null)
        {
            if(Integer.valueOf(result.toString())>0)
            {
                return validation.that_ok(true);
            }
            return  validation.item_not_found(result);
        }
        return validation.not_data_base();

   }

    public Object remove(String collection, Document where){

        Object result = simpleCrud.remove(collection,where);

        if (result!=null)
        {
            if(Integer.valueOf(result.toString())>0)
            {
                return validation.that_ok(true);
            }
            return  validation.item_not_found(result);
        }
        return validation.not_data_base();

    }

   public Object findRule(Object result)
   {
       List listResult = (List) result;
       if (listResult.size() > 0)
       {
           Document persons = new  Document();
           persons.put("persons",listResult);
           return validation.that_ok(listResult);
       }
       return  validation.item_not_found(false);
   }
}
