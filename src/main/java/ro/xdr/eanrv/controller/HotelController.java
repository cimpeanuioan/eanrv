package ro.xdr.eanrv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.xdr.eanrv.dao.HotelIdDao;
import ro.xdr.eanrv.model.HotelId;

/**
 * Created by ioan.cimpeanu on 12.01.2015.
 */

@Controller(value = "/api/hotelid")
public class HotelController {

    @Autowired
    private HotelIdDao hotelIdDao;

    public HotelController() {
    }

    // HOST_IP/api/hotelid/save?hotelId=12512&hotelName=ceva&processed=true
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, name = "/save")
    public String getHotelById(@RequestParam(value = "hotelId") Integer hotelId,
                               @RequestParam(value = "hotelName") String hotelName,
                               @RequestParam(value = "processed") Boolean processed){

        HotelId entity = new HotelId(hotelId, hotelName, processed);
        HotelId savedEntity = hotelIdDao.save(entity);

        return savedEntity.toString();
    }
}
