package com.thedionisio.model.ctrl;

import com.thedionisio.dao.CompanyRepository;
import com.thedionisio.model.bss.CompanyBss;
import com.thedionisio.model.dto.Company;
import com.thedionisio.util.mongo.Mongo;
import com.thedionisio.util.verification.Validation;
import org.bson.Document;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by jonathan on 4/9/17.
 */
public class CompanyCtrl {

    private CompanyBss companyBss = new CompanyBss();
    private CompanyRepository companyRepository = new CompanyRepository();
    private final String collection  ="company";

    public Object create(Company company){

        try
        {
            if(company.createValidation())
            {
                if (companyBss.existingValidation(company))
                {
                    ResponseEntity responseEntity = companyRepository.create(collection, company.treatCreate());
                    try
                    {
                        if (Boolean.parseBoolean(responseEntity.getBody().toString()))
                        {
                            List<Company> companies = (List<Company>) companyRepository.findByEmail(company.email);
                            System.out.println(companies.get(0)._id);
                            Object companyResponse = Mongo.treatMongoId.toString(companies.get(0)._id);
                            return Validation.resquest.REGISTRY_CREATE(companyResponse);
                        }
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.getCause());
                        return responseEntity;
                    }

                }
                return Validation.resquest.REGISTRY_EXISTED(company.attributeIdentifier() + company.email);
            }
            return Validation.resquest.NOT_CONTAINS_FIELDS(company.isRequered());
        }
        catch (Exception e)
        {
            return Validation.resquest.NOT_DATA_BASE();
        }

    }

    public Object find(){

        Object objectResponse = companyRepository.find(collection,new Company(), new Document(), new Document());

        try
        {
            ResponseEntity<Object> responseEntity = (ResponseEntity<Object>) objectResponse;
            List<Company> companies = (List<Company>) responseEntity.getBody();
            return companyBss.treatResponse(companies);
        }
        catch (Exception e)
        {
            return objectResponse;
        }
    }

    public Object findOne(Object id){
        try
        {
            if(Validation.resquest.idValidation(id))
            {
                Object objectResponse = companyRepository.findOne(collection,id, new Company());
                ResponseEntity<Object> responseEntity = (ResponseEntity<Object>) objectResponse;
                List<Company> companies = (List<Company>) responseEntity.getBody();
                return companyBss.treatResponse(companies);
            }
            return Validation.resquest.NOT_CONTAINS_ID();
        }
        catch (Exception e)
        {
            return Validation.resquest.NOT_DATA_BASE();
        }
    }

    public Object update(Company company){

        try
        {
            if(Validation.resquest.idValidation(company._id))
            {
                Object objectResponse = companyRepository.update(collection, company._id, company);
                try
                {
                    if((Boolean) objectResponse)
                    {
                        return Validation.resquest.REGISTRY_CREATE(company._id);
                    }
                }catch (Exception e)
                {
                    return objectResponse;
                }

            }
            return Validation.resquest.NOT_CONTAINS_ID();
        }
        catch (Exception e)
        {
            return Validation.resquest.NOT_DATA_BASE();
        }
    }

    public Object remove(Company company){
        try
        {
            if(Validation.resquest.idValidation(company._id))
            {
                Object objectResponse = companyRepository.removeOne(collection, company._id);

                ResponseEntity<Object> responseEntity = (ResponseEntity<Object>) objectResponse;

                try
                {
                    if ((Boolean)responseEntity.getBody())
                    {
                        return  Validation.resquest.REGISTRY_DELETED(company._id);
                    }
                }
                catch (Exception e)
                {
                    return responseEntity;
                }
            }
            return Validation.resquest.NOT_CONTAINS_ID();
        }
        catch (Exception e)
        {
            return Validation.resquest.NOT_DATA_BASE();
        }

    }



}
