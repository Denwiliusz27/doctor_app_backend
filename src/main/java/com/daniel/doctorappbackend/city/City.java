package com.daniel.doctorappbackend.city;

import lombok.Data;

import javax.persistence.*;

//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
@Data
@Entity
//@ToString
@Table(name = "miasta")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_miasta")
    private Long cityId;

    @Column(name = "nazwa")
    private String cityName;

    public City() {
        cityId = 0L;
        cityName = "";
    }

    public City(long cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public City(String cityName) {
        this.cityName = cityName;
    }

    public long getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "idMiasta = " + cityId + " nazwa: " + cityName;
    }

}
//@Setter
