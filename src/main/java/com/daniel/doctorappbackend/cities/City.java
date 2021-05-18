package com.daniel.doctorappbackend.cities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    private Long idMiasta;

    @Column
    private String nazwa;

    public City() {
        idMiasta = 0L;
        nazwa = "";
    }

    public City(long idMiasta, String nazwa) {
        this.idMiasta = idMiasta;
        this.nazwa = nazwa;
    }

    public long getIdMiasta() {
        return idMiasta;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setIdMiasta(long idMiasta) {
        this.idMiasta = idMiasta;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "idMiasta = " + idMiasta + " nazwa: " + nazwa;
    }


}
//@Setter
