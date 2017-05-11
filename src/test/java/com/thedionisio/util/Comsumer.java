package com.thedionisio.util;

import com.thedionisio.util.consumer.ConsumerAPI;
import org.bson.Document;
import org.junit.Test;

/**
 * Created by jonathan on 5/7/17.
 */
public class Comsumer {

    @Test
    public void ca(){

        Object a = new ConsumerAPI("").get("error/401");

        System.out.println("ad");

    }

}
