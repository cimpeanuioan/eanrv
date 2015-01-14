package ro.xdr.eanrv.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ro.xdr.eanrv.dao.ComparisonDao;
import ro.xdr.eanrv.dao.DifferenceDao;
import ro.xdr.eanrv.dao.HotelIdDao;
import ro.xdr.eanrv.model.Comparison;
import ro.xdr.eanrv.model.Difference;
import ro.xdr.eanrv.model.HotelId;

/**
 * Created by ioan.cimpeanu on 12.01.2015.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/persistence-context.xml");

     //   HotelIdDao hotelIdDao = context.getBean(HotelIdDao.class);

       // HotelId hotelId = new HotelId(32145, "testhotel", true);
      // HotelId hotelId1 = new HotelId(32145, "testhotel", false);
      //  hotelIdDao.save(hotelId);
       // hotelIdDao.save(hotelId1);

        ComparisonDao comparisonDao = context.getBean(ComparisonDao.class);
        Comparison comparison1 = new Comparison(3, "httprqA", "httprqB", "Responsea", "ResponseB", true);
        comparisonDao.save(comparison1);

       // DifferenceDao differenceDao = context.getBean(DifferenceDao.class);
      //  Difference difference1 = new Difference(1, 2, "valueAdd", "ValueA", "ValueB");
      //  differenceDao.save(difference1);






    }
}
