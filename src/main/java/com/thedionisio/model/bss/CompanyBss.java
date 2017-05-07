package com.thedionisio.model.bss;

import com.thedionisio.dao.CompanyRepository;
import com.thedionisio.model.dto.Company;
import com.thedionisio.util.mongo.Mongo;
import com.thedionisio.util.verification.Description;
import org.bson.Document;

import java.util.List;

/**
 * Created by jonathan on 4/9/17.
 */
public class CompanyBss {

    CompanyRepository companyRepository = new CompanyRepository();

    public Boolean existingValidation(Company company){
        try
        {
            List list = (List) companyRepository.findByEmail(company.email);

            return list.size() <= 0;
        }
        catch (Exception e )
        {
            return null;
        }

    }

    public Document treatResponse(List<Company> companies){
        companies.forEach(c->{
            c._id = Mongo.treatMongoId.toString(c._id);
            c.password = Description.PASSWORD_SHADOW;
        });

        Document response = new Document();
        response.put("companies", companies);
        return response;
    }
}
