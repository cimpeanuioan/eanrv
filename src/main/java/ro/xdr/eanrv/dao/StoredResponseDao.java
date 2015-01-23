package ro.xdr.eanrv.dao;

import ro.xdr.eanrv.model.StoredResponse;

/**
 * Created by ioan.cimpeanu on 13.01.2015.
 */
public interface StoredResponseDao extends EntityDao<StoredResponse, Integer> {


    @Override
    StoredResponse save(final StoredResponse entity);
}
