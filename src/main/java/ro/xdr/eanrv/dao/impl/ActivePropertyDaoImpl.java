package ro.xdr.eanrv.dao.impl;

import org.springframework.stereotype.Repository;
import ro.xdr.eanrv.dao.ActivePropertyDao;
import ro.xdr.eanrv.model.ActiveProperty;

/**
 * Created by ioan.cimpeanu on 12.01.2015.
 */

@Repository
public class ActivePropertyDaoImpl extends AbstractEntityDaoImpl<ActiveProperty, Integer> implements ActivePropertyDao {

    @Override
    public ActiveProperty save(ActiveProperty entity) {
        if (super.find(entity.getEanHotelId()) != null) {
            return super.save(entity);
        } else {
            return null;
        }
    }
}
