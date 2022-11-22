package com.example.hibernateplayground.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "station")
public class Station implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "branch_id")
    private Integer branchId;

    @Column(name = "station_name")
    private String stationName;

    @Column(name = "station_master")
    private Integer stationMaster;
}
