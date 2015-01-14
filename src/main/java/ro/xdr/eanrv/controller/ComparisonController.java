package ro.xdr.eanrv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.xdr.eanrv.dao.ComparisonDao;
import ro.xdr.eanrv.model.Comparison;


/**
 * Created by ioan.cimpeanu on 12.01.2015.
 */

@Controller(value = "/api/comparison")
public class ComparisonController {

    @Autowired
    private ComparisonDao comparisonDao;

    public ComparisonController() {
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, name = "/comparison")
    public String getHotelById(@RequestParam(value = "id") Integer id,
                               @RequestParam(value = "HttpRqA") String HttpRqA,
                               @RequestParam(value = "HttpRqB") String HttpRqB,
                               @RequestParam(value = "ResponseA") String ResponseA,
                               @RequestParam(value = "ResponseB") String ResponseB,
                               @RequestParam(value = "Invalid") Boolean Invalid)



                               {

        Comparison entity = new Comparison(id, HttpRqA, HttpRqB, ResponseA, ResponseB, Invalid);

        Comparison savedEntity =  comparisonDao.save(entity);

        return savedEntity.toString();
    }
}
