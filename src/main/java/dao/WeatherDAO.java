package dao;

import entity.WeatherData;
import org.hibernate.Transaction;
import org.hibernate.Session;
import util.hibernateUtil;


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

}
