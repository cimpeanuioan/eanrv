package ro.xdr.eanrv.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ro.xdr.eanrv.dao.HotelIdDao;
import ro.xdr.eanrv.model.HotelId;

/**
 * Created by ioan.cimpeanu on 12.01.2015.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/persistence-context.xml");

        HotelIdDao hotelIdDao = context.getBean(HotelIdDao.class);

        HotelId hotelId = new HotelId(32145, "testhotel", true);
        HotelId hotelId1 = new HotelId(32145, "testhotel", false);
        hotelIdDao.save(hotelId);
        hotelIdDao.save(hotelId1);
    }
}
