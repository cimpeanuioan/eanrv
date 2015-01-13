package ro.xdr.eanrv.dao;

import ro.xdr.eanrv.model.HotelId;

/**
 * Created by ioan.cimpeanu on 12.01.2015.
 */
public interface HotelIdDao extends EntityDao<HotelId, Integer> {

    /**
     * Saves a new HotelId entity into the database
     * @param entity The new HotelId entity to be saved.
     * @return       The data of the HotelId entity that was saved, if successful or null
     *               if another entity with the same ID was found.
     */
    @Override
    HotelId save(final HotelId entity);
}
