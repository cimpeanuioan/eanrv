package ro.xdr.eanrv.dao;

import ro.xdr.eanrv.model.Difference;

/**
 * Created by ioan.cimpeanu on 13.01.2015.
 */
public interface DifferenceDao extends EntityDao<Difference, Integer> {

    @Override
    Difference save(final Difference entity);
}
