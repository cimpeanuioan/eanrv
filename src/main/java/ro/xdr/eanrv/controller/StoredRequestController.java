package ro.xdr.eanrv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.xdr.eanrv.dao.StoredRequestDao;
import ro.xdr.eanrv.model.StoredRequest;
/**
 * Created by ioan.cimpeanu on 13.01.2015.
 */
@Controller(value = "/api/stored_request")
public class StoredRequestController {

    @Autowired
    private StoredRequestDao storedRequestDao;

    public StoredRequestController() {
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, name = "/getById")
    public String getRequestById(@RequestParam(value = "requestId") Integer requestId) {
        // TODO implement
        return null;
    }


}
