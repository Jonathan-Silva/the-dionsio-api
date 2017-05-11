package com.thedionisio.model.bss;

import com.thedionisio.model.dto.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonathan on 3/6/17.
 */
public class EventBss {
    public Boolean existingValidation(String collection, Event event){
        try
        {
           List list = new ArrayList();

            return list.size() <= 0;
        }
        catch (Exception e )
        {
           return null;
        }

    }


}
