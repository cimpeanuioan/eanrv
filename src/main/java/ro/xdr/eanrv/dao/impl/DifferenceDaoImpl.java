package ro.xdr.eanrv.dao.impl;

import org.springframework.stereotype.Repository;
import ro.xdr.eanrv.dao.DifferenceDao;
import ro.xdr.eanrv.model.Difference;

/**
 * Created by ioan.cimpeanu on 13.01.2015.
 */

@Repository
public class DifferenceDaoImpl extends AbstractEntityDaoImpl<Difference, Integer> implements DifferenceDao {

    @Override
    public Difference save(Difference entity) {
        if (super.find(entity.getComparisonId()) == null) {
            return super.save(entity);
        } else {
            return null;
        }
    }
}
