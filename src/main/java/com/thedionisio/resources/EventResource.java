package com.thedionisio.resources;

import com.thedionisio.model.ctrl.EventCtrl;
import com.thedionisio.model.dto.Event;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jonathan on 3/11/17.
 */


@RestController
@RequestMapping(value = "/event")
public class EventResource {

    private EventCtrl eventCtrl = new EventCtrl();

    @RequestMapping(method = RequestMethod.GET)
    public Object get() throws IllegalAccessException {
        return eventCtrl.find();
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    public Object getOne(@PathVariable Object id)  {
        return  eventCtrl.asd();
       // return eventCtrl.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Object create(@RequestBody Event event)  {
        return this.eventCtrl.create(event);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Object update(@RequestBody Event event) {
        return this.eventCtrl.update(event);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Object remove(@RequestBody Event Event) {
        return this.eventCtrl.removeOne(Event);
    }

}



