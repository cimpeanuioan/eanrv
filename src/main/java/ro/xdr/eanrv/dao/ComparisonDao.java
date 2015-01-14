package ro.xdr.eanrv.dao;

import ro.xdr.eanrv.model.Comparison;

/**
 * Created by ioan.cimpeanu on 13.01.2015.
 */
public interface ComparisonDao extends EntityDao<Comparison, Integer> {


    @Override
    Comparison save(final Comparison entity);
}
