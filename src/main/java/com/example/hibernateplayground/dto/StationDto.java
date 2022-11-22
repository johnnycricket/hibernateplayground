package com.example.hibernateplayground.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StationDto {
    private Integer id;

    private Integer branchId;
    
    private String stationName;

    private Integer stationMaster;
}
