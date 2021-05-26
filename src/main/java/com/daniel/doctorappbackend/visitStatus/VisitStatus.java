package com.daniel.doctorappbackend.visitStatus;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "statusy_wizyt")
public class VisitStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_statusu")
    private Long statusId;

    @Column(name = "nazwa")
    private String statusName;

    public VisitStatus() {
        statusId = 0L;
        statusName = "";
    }

    public VisitStatus(long statusID, String statusName) {
        this.statusId = statusID;
        this.statusName = statusName;
    }

    public VisitStatus(String statusName) {
        this.statusName = statusName;
    }

    public long getStatusId() {
        return statusId;
    }

    public void setStatusId(long statusID) {
        this.statusId = statusID;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String name) {
        this.statusName = name;
    }

    @Override
    public String toString() {
        return  "statusID= " + statusId +
                ", name='" + statusName + '\'';
    }
}
