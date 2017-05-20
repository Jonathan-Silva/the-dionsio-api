package com.thedionisio.model.bss;

import com.thedionisio.dao.CompanyRepository;
import com.thedionisio.model.dto.Company;
import org.bson.Document;
import sun.font.EAttribute;

import java.util.List;

/**
 * Created by jonathan on 4/9/17.
 */
public class CompanyBss {

    private CommonPersonCompanyBss commonPersonCompanyBss = new CommonPersonCompanyBss();
    private CompanyRepository companyRepository = new CompanyRepository();
    private final String collection  ="company";
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

    public Boolean isActiveCompany(Object id){

        try
        {
            List<Company> listCompany = (List<Company>) companyRepository.findOne(collection,id, new Company());
            return listCompany.get(0).isActive;
        }
        catch (Exception e)
        {
            return false;
        }

    }
}
