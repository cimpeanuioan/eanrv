package ro.xdr.eanrv.dao.impl;

import org.springframework.stereotype.Repository;
import ro.xdr.eanrv.dao.StoredRequestDao;
import ro.xdr.eanrv.model.StoredRequest;

/**
 * Created by ioan.cimpeanu on 13.01.2015.
 */

@Repository
public class StoredRequestDaoImpl extends AbstractEntityDaoImpl<StoredRequest, Integer> implements StoredRequestDao {

    @Override
    public StoredRequest save(StoredRequest entity) {
        if (super.find(entity.getRequestId()) != null) {
            return super.save(entity);
        } else {
            return null;
        }
    }
}
