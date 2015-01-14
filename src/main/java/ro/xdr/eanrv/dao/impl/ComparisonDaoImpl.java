package ro.xdr.eanrv.dao.impl;

import org.springframework.stereotype.Repository;
import ro.xdr.eanrv.dao.ComparisonDao;
import ro.xdr.eanrv.model.Comparison;

/**
 * Created by ioan.cimpeanu on 13.01.2015.
 */

@Repository
public class ComparisonDaoImpl extends AbstractEntityDaoImpl<Comparison, Integer> implements ComparisonDao {

    @Override
    public Comparison save(Comparison entity) {
        if (super.find(entity.getComparisonId()) != null) {
            return super.save(entity);
        } else {
            return null;
        }
    }

}
