package com.thedionisio.util.verification;

/**
 * Created by jonathan on 3/3/17.
 */
public interface Description {
     String problems_database = "problems in the database";
     String not_found_info ="required information not declared";
     String register_existed = "register already exists";
     String register_not_found = "register not found";
     String register_deleted = "register deleted successfully";
     String register_created = "register created successfully";
     String register_updated = "register updated successfully";

     String check_mongo_conection = "check your mongoDB connection";
     String required_id ="field <_id> is required";
     String required_fields ="fields required: ";
     String field_existed = "> already registered in the system";
     String not_registed = "no register were found that satisfies the condition";
     String reference_id = "reference _id = ";

     String password = "you shall not pass";

}
