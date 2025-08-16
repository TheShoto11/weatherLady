package entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity

public class WeatherData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id gjenerohet automatikisht
    private Long id;
    private LocalDate date; //data e marrjes se te dhenave
    private double temp;
    private double pressure;
    private double humidity;
    private double windDirection;
    @ManyToOne
    @JoinColumn(name = "location_id")//kjo esht kolona qe lidhet me lokacionin
    private Location location;//lidhja me klasen location
    public WeatherData(){}

    public WeatherData( Location location, double windDirection, double humidity, double pressure, double temp, LocalDate date) {
        this.location = location;
        this.windDirection = windDirection;
        this.humidity = humidity;
        this.pressure = pressure;
        this.temp = temp;
        this.date = date;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(double windDirection) {
        this.windDirection = windDirection;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "id=" + id +
                ", date=" + date +
                ", temp=" + temp +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", windDirection=" + windDirection +
                ", location=" + location +
                '}';
    }
}
