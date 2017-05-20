package com.thedionisio.model.bss;

import com.thedionisio.model.dto.Company;
import com.thedionisio.util.mongo.Mongo;
import com.thedionisio.util.verification.Description;
import org.bson.Document;

import java.util.List;

/**
 * Created by jonathan on 4/9/17.
 */
public class CompanyBss {

    private CommonPersonCompanyBss commonPersonCompanyBss = new CommonPersonCompanyBss();

    public Boolean existingValidation(Company company){
        try
        {
            return commonPersonCompanyBss.existingValidation(company.email);
        }
        catch (Exception e )
        {
            return null;
        }

    }

    public Document treatResponse(List<Company> companies){
        companies.forEach(c->{
            c.treatResponse();
        });

        Document response = new Document();
        response.put("companies", companies);
        return response;
    }
}
