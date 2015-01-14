package ro.xdr.eanrv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.xdr.eanrv.dao.DifferenceDao;
import ro.xdr.eanrv.model.Difference;
/**
 * Created by ioan.cimpeanu on 13.01.2015.
 */
@Controller(value = "/api/difference")
public class DifferenceController {

    @Autowired
    private DifferenceDao differenceDao;

    public DifferenceController() {
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, name = "/difference")
    public String getHotelById(@RequestParam(value = "differenceId") Integer differenceId,
                               @RequestParam(value = "comparisonId") Integer comparisonId,
                               @RequestParam(value = "node") String node,
                               @RequestParam(value = "valueA") String valueA,
                               @RequestParam(value = "valueB") String valueB)       {

        Difference entity = new Difference(differenceId, comparisonId, node, valueA, valueB);

        Difference savedEntity =  differenceDao.save(entity);

        return savedEntity.toString();
    }


}
