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
@Table(name = "branch_station")
public class BranchStation implements Serializable {
    @Id
    @Getter
    @Column(name = "id")
    private Integer id;

    @Getter
    @Column(name = "branch_id")
    private Integer branchId;
}
