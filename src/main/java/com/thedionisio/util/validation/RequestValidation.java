package com.thedionisio.util.validation;

import com.thedionisio.model.dto.Validation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by jonathan on 2/28/17.
 */
public class RequestValidation {

    private Validation validation = new Validation();

    //estrutruras de respostas
    private Validation notContainsID()
    {
        validation.status = HttpStatus.NOT_ACCEPTABLE;
        validation.description = Description.not_found_info;
        validation.additional =Description.required_id;

       return validation;
    }
    private Validation notContainsFields(String fields)
    {
        validation.status = HttpStatus.NOT_ACCEPTABLE;
        validation.description = Description.not_found_info;
        validation.additional = Description.required_fields + fields;

        return validation;
    }
    private Validation notDataBase()
    {
        validation.status = HttpStatus.INSUFFICIENT_STORAGE;
        validation.description = Description.problems_database;
        validation.additional = Description.check_mongo_conection;

        return validation;
    }
    private Validation existing(String field)
    {
        validation.status = HttpStatus.NOT_ACCEPTABLE;
        validation.description = Description.register_existed;
        validation.additional = field + Description.field_existed;

        return validation;
    }
    private Validation not_found()
    {
        validation.status = HttpStatus.NOT_FOUND;
        validation.description = Description.register_not_found;
        validation.additional = Description.not_registed;

        return validation;
    }
    private Validation registryDeleted(String id)
    {
        validation.status = HttpStatus.OK;
        validation.description = Description.register_deleted;
        validation.additional = Description.reference_id + id;

        return validation;
    }
    private Validation registryCreate(String id)
    {
        validation.status = HttpStatus.OK;
        validation.description = Description.register_created;
        validation.additional = Description.reference_id + id;

        return validation;
    }
    private Validation registryUpdate(String id)
    {
        validation.status = HttpStatus.OK;
        validation.description = Description.register_updated;
        validation.additional = Description.reference_id + id;

        return validation;
    }

    //global validação de id
    public Boolean idValidation(Object _id){
        if(_id!=null){
            return true;
        }
        return false;
    }

    //responses montados
    public ResponseEntity not_contains_id(){
        return new ResponseEntity<Object>(notContainsID(), HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity not_contains_fields(String fields){
        return new ResponseEntity<Object>(notContainsFields(fields), HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity not_data_base(){
        return new ResponseEntity<Object>(notDataBase(), HttpStatus.INSUFFICIENT_STORAGE);
    }

    public ResponseEntity registry_existed(String field){
        return new ResponseEntity<Object>(existing(field), HttpStatus.NOT_ACCEPTABLE);
    }

    public ResponseEntity item_not_found(Object object){
        return new ResponseEntity<Object>(not_found(), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity that_ok(Object object){
        return new ResponseEntity<Object>(object, HttpStatus.OK);

    }
    public ResponseEntity registry_deleted(Object id){
        return new ResponseEntity<Object>(registryDeleted(id.toString()), HttpStatus.OK);
    }
    public ResponseEntity registry_create(Object id){
        return new ResponseEntity<Object>(registryCreate(id.toString()), HttpStatus.OK);
    }
    public ResponseEntity registry_update(Object id){
        return new ResponseEntity<Object>(registryUpdate(id.toString()), HttpStatus.OK);
    }
}
