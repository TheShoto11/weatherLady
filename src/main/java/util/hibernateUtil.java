package util;

import entity.Location;
import entity.WeatherData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernateUtil {
    //obj qe krijon dhe menaxhon sessionet ne hibernate
    //session esht lidhje me DB dhe perdoret per realizimin e operacionve CRUD por pa create
    //ske pse krijon obj per thirrjen e var statike
    private static SessionFactory sessionFactory;
    //ekz nje her ne inicialicim
    static {
        try{
            //thirrjen e metodes configure() per te lexuar file-in tek resurset.
            //i cili ka konfikurimet e hibernate
            sessionFactory=new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Location.class)
                    .addAnnotatedClass(WeatherData.class)
                    //ktu siper shtum klasat annotation @Entity ose @Table
                    .buildSessionFactory();
        }catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }

    }
    public static Session getSession(){
       return sessionFactory.openSession();
    }
    public static void shutDown(){
         sessionFactory.close();
    }
}
