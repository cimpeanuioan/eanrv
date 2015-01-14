package ro.xdr.eanrv.dao.impl;

import org.springframework.stereotype.Repository;
import ro.xdr.eanrv.dao.HotelIdDao;
import ro.xdr.eanrv.model.HotelId;

/**
 * Created by ioan.cimpeanu on 12.01.2015.
 */

@Repository
public class HotelIdDaoImpl extends AbstractEntityDaoImpl<HotelId, Integer> implements HotelIdDao {

    @Override
    public HotelId save(HotelId entity) {
        if (super.find(entity.getEanHotelId()) == null) {
            return super.save(entity);
        } else {
            return null;
        }

    }
}
