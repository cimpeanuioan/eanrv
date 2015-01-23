package ro.xdr.eanrv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.xdr.eanrv.dao.ActivePropertyDao;

/**
 * Created by ioan.cimpeanu on 12.01.2015.
 */

@Controller(value = "/api/hotel")
public class HotelController {

    @Autowired
    private ActivePropertyDao activePropertyDao;

    public HotelController() {
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, name = "/getById")
    public String getHotelById(@RequestParam(value = "hotelId") Integer hotelId){
        //TODO implement
        return null;
    }
}
