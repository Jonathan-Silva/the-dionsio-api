package com.thedionisio.resources;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by jonathan on 3/22/17.
 */
@Controller
@ComponentScan()
@RequestMapping(value = "/documentation")
public class DocResource {
    @RequestMapping(value = "/{collection:.+}", method = RequestMethod.GET)
    public ModelAndView getDocumentation(@PathVariable String collection) {
        switch (collection)
        {
            case "person" :
                return new ModelAndView("doc/person");

            default:
                return new ModelAndView("doc/person");

        }

    }








}
