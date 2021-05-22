package com.daniel.doctorappbackend.status;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "statusy_wizyt")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idStatusu;

    @Column
    private String nazwa;

    public Status() {
        idStatusu = 0L;
        nazwa = "";
    }

    public Status(long statusID, String nazwa) {
        this.idStatusu = statusID;
        this.nazwa = nazwa;
    }

    public Status(String nazwa) {
        this.nazwa = nazwa;
    }

    public long getIdStatusu() {
        return idStatusu;
    }

    public void setIdStatusu(long statusID) {
        this.idStatusu = statusID;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String name) {
        this.nazwa = name;
    }

    @Override
    public String toString() {
        return  "statusID= " + idStatusu +
                ", name='" + nazwa + '\'';
    }
}
