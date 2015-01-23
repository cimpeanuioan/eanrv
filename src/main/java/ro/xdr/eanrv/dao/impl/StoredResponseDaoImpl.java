package ro.xdr.eanrv.dao.impl;

import org.springframework.stereotype.Repository;
import ro.xdr.eanrv.dao.StoredResponseDao;
import ro.xdr.eanrv.model.StoredResponse;

/**
 * Created by ioan.cimpeanu on 13.01.2015.
 */

@Repository
public class StoredResponseDaoImpl extends AbstractEntityDaoImpl<StoredResponse, Integer> implements StoredResponseDao {

    @Override
    public StoredResponse save(StoredResponse entity) {
        if (super.find(entity.getResponseId()) != null) {
            return super.save(entity);
        } else {
            return null;
        }
    }

}
