package com.thedionisio.util.consumer;

import com.google.gson.Gson;
import com.thedionisio.model.dto.ResponseObeject;
import com.thedionisio.model.dto.Validation;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by jonathan on 3/13/17.
 */
public class ConsumerAPI {

    private Object convertObject;
    private Object body;

    private ResponseObeject comsumer(String uri, HttpMethod httpMethod){
        int statusCode = 0;
        RestClient restClient = new RestClient("jonatabldeudvujvçu");
        ResponseObeject responseObeject = new ResponseObeject();
        ResponseEntity reponse = new ResponseEntity(HttpStatus.BAD_REQUEST);

        try
        {

            switch (httpMethod)
            {
                case GET:
                    reponse = restClient.get(uri);
                    break;
                case POST:
                    reponse = restClient.post(uri, new Gson().toJson(body));
                    break;
                case PUT:
                    reponse = restClient.put(uri, new Gson().toJson(body));
                    break;
                case DELETE:
                    reponse = restClient.delete(uri, new Gson().toJson(body));
                    break;

            }




            statusCode = reponse.getStatusCodeValue();
        }
        catch (Exception e)
        {
            //make a log
            statusCode = 0;
        }
        finally
        {
            switch (statusCode){
                case 200:
                    responseObeject.statusCode=statusCode;
                    responseObeject.object = toJavaObject(reponse.getBody());
                    break;
                case 404:
                    responseObeject.statusCode=statusCode;
                    responseObeject.object = toErrorObject(reponse.getBody());
                    break;
                case 406:
                    responseObeject.statusCode=statusCode;
                    responseObeject.object = toErrorObject(reponse.getBody());
                    break;
                case 509:
                    responseObeject.statusCode=statusCode;
                    responseObeject.object = toErrorObject(reponse.getBody());
                    break;
                default:
                    responseObeject.statusCode=statusCode;
                    responseObeject.object = toErrorObject(reponse.getBody());
                    break;
            }
        }

        return  responseObeject;
    }

    private Object toJavaObject(Object object){


        return object;

    }

    private Object toErrorObject(Object object){

        Validation validation = new Gson().fromJson(object.toString(), Validation.class);

        return validation;

    }

    //responses
    public ResponseObeject get(String uri, Object object){
        convertObject = object;
        return comsumer(uri,HttpMethod.GET);
    }

    public ResponseObeject post(String uri, Object postBody, Object object){
        convertObject = object;
        body = postBody;
        return comsumer(uri,HttpMethod.POST);
    }

    public ResponseObeject put(String uri, Object putBody, Object object){
        convertObject = object;
        body = putBody;
        return comsumer(uri,HttpMethod.PUT);
    }

    public ResponseObeject delete(String uri, Object deleteBody, Object object){
        convertObject = object;
        body = deleteBody;
        return comsumer(uri,HttpMethod.DELETE);
    }



}
