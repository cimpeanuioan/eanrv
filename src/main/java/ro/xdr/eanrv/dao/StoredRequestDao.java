package ro.xdr.eanrv.dao;

import ro.xdr.eanrv.model.StoredRequest;

/**
 * Created by ioan.cimpeanu on 13.01.2015.
 */
public interface StoredRequestDao extends EntityDao<StoredRequest, Integer> {

    @Override
    StoredRequest save(final StoredRequest entity);
}
