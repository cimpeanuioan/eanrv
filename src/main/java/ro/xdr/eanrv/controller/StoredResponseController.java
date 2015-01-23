package ro.xdr.eanrv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.xdr.eanrv.dao.StoredResponseDao;


/**
 * Created by ioan.cimpeanu on 12.01.2015.
 */

@Controller(value = "/api/stored_response")
public class StoredResponseController {

    @Autowired
    private StoredResponseDao storedResponseDao;

    public StoredResponseController() {
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, name = "/getByHotelId")
    public String getHotelById(@RequestParam(value = "hotelId") Integer hotelId) {
        // TODO implement
        return null;
    }
}
