package com.thedionisio.util.verification;

import com.thedionisio.model.dto.Validation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by jonathan on 2/28/17.
 */
public class RequestValidation {

    private Validation validation = new Validation();

    private Validation notContainsID()
    {
        validation.status = HttpStatus.NOT_ACCEPTABLE;
        validation.description = Description.NOT_FOUND_INFO;
        validation.additional =Description.REQUIRED_ID;

       return validation;
    }
    private Validation notContainsFields(String fields)
    {
        validation.status = HttpStatus.NOT_ACCEPTABLE;
        validation.description = Description.NOT_FOUND_INFO;
        validation.additional = Description.REQUIRED_FIELDS + fields;

        return validation;
    }
    private Validation notDataBase()
    {
        validation.status = HttpStatus.INSUFFICIENT_STORAGE;
        validation.description = Description.PROBLEMS_DATABASE;
        validation.additional = Description.CHECK_MONGO_CONNECTION;

        return validation;
    }
    private Validation existing(String field)
    {
        validation.status = HttpStatus.NOT_ACCEPTABLE;
        validation.description = Description.REGISTER_EXISTED;
        validation.additional = field + Description.FIELD_EXISTED;

        return validation;
    }
    private Validation notFound()
    {
        validation.status = HttpStatus.NOT_FOUND;
        validation.description = Description.REGISTER_NOT_FOUND;
        validation.additional = Description.NOT_REGISTERED;

        return validation;
    }
    private Validation notAutorized()
    {
        validation.status = HttpStatus.UNAUTHORIZED;
        validation.description = Description.REQUEST_NOT_AUTHORIZED;
        validation.additional = Description.BAD_CREDENTIALS;

        return validation;
    }
    private Validation registryDeleted(String id)
    {
        validation.status = HttpStatus.OK;
        validation.description = Description.REGISTER_DELETED;
        validation.additional = Description.REFERENCE_ID + id;

        return validation;
    }
    private Validation registryCreate(String id)
    {
        validation.status = HttpStatus.OK;
        validation.description = Description.REGISTER_CREATED;
        validation.additional = Description.REFERENCE_ID + id;

        return validation;
    }
    private Validation registryUpdate(String id)
    {
        validation.status = HttpStatus.OK;
        validation.description = Description.REGISTER_UPDATED;
        validation.additional = Description.REFERENCE_ID + id;

        return validation;
    }

    /**
     * Global validation for _ID
     * @param _id
     * @return
     */
    public Boolean idValidation(Object _id){
        return _id != null;
    }

    //responses montados
    public ResponseEntity NOT_CONTAINS_ID(){
        return new ResponseEntity<Object>(notContainsID(), HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity NOT_CONTAINS_FIELDS(String fields){
        return new ResponseEntity<Object>(notContainsFields(fields), HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity NOT_DATA_BASE(){
        return new ResponseEntity<Object>(notDataBase(), HttpStatus.INSUFFICIENT_STORAGE);
    }

    public ResponseEntity REGISTRY_EXISTED(String field){
        return new ResponseEntity<Object>(existing(field), HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity ITEM_NOT_FOUND(Object object){
        return new ResponseEntity<Object>(notFound(), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity THAT_OK(Object object){
        return new ResponseEntity<Object>(object, HttpStatus.OK);

    }

    public ResponseEntity REGISTRY_DELETED(Object id){
        return new ResponseEntity<Object>(registryDeleted(id.toString()), HttpStatus.OK);
    }

    public ResponseEntity REGISTRY_CREATE(Object id){
        return new ResponseEntity<Object>(registryCreate(id.toString()), HttpStatus.OK);
    }

    public ResponseEntity REGISTRY_UPDATE(Object id){
        return new ResponseEntity<Object>(registryUpdate(id.toString()), HttpStatus.OK);
    }


    public ResponseEntity REQUEST_NOT_AUTHORIZED(){
        return new ResponseEntity<Object>(notAutorized(), HttpStatus.UNAUTHORIZED);
    }
}
