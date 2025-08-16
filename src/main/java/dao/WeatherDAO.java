package dao;

import entity.WeatherData;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.hibernateUtil;

import java.util.List;


//klasa dao sherben per percaktimin e te dhenave qe duam te dergojm
//dhe cfar te dhenash presim per te marr
//per siguri
public class WeatherDAO {
    //metoda per ruajtjen e objektit te tipit weatherdata ne db

    public void saveWeatherData (WeatherData weatherData){
        Session session = hibernateUtil.getSession();

        //nje transaction esht grup operacionesh qe duhen perfunduar te gjitha me sukses
        //ose nuk behet fare. Nese ndodh nje problem gjat ekz duhet ta anullosh
        //qe te sigurojm konsistenc dhe integritet te dhenash
        Transaction transaction= session.beginTransaction();
        session.persist(weatherData);//ruan obj weatherData ne db
                                    //krijon rresht te ri ne db/tabel
        transaction.commit();//siguron qe ndryshimet jan ruajtur ne db
    }
public List<WeatherData>getWeatherDataByLocation(String city,String country){
    Session session = hibernateUtil.getSession();
    Transaction transaction= session.beginTransaction();
    //query per te marr te dhenat e motit per qytetin dhe vendin
    //qe kemi vendos. Kjo metode ekzekuton nje HQL (Hibernate Query Language)
    String hql= "FROM WeatherData wd where wd.location.city = :city AND wd.location.country";

    //krijojm query tbazuar ne hql dhe ekz ne entity WeatherData
    Query<WeatherData> query =session.createQuery(hql,WeatherData.class);
    query.setParameter("city",city);
    query.setParameter("country",country);
    List<WeatherData>weatherDataList=query.list();
    transaction.commit();
    return weatherDataList;
}
}
