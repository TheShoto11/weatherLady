package dao;

import entity.Location;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.hibernateUtil;

public class LocationDAO {

    public void saveLocation(Location location){
        Session session= hibernateUtil.getSession();
        Transaction transaction=session.beginTransaction();
        session.persist(location);
        transaction.commit();
    }


    public  Location getLocationByCityAndCountry(String city,String country){
    Session session = hibernateUtil.getSession();
    Transaction transaction= session.beginTransaction();

    String hql ="From Location where city = :city AND country = :country";
        Query<Location>query= session.createQuery(hql,Location.class);
        query.setParameter("city",city);
        query.setParameter("country",country);

        Location location = query.uniqueResult(); //kthen vtm nje location qe perputhet
        transaction.commit();

        return location;
    }
}