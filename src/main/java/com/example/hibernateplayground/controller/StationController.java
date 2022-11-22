package com.example.hibernateplayground.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hibernateplayground.dto.StationDto;
import com.example.hibernateplayground.model.Station;
import com.example.hibernateplayground.service.StationService;

@RestController
public class StationController {
    private final StationService stationService;

    @Autowired
    public StationController(StationService stationService) {
        this.stationService = stationService;
    }
    
    @GetMapping(value = "/station/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<StationDto> getStationById(@PathVariable int id) throws Exception{
        StationDto station = stationService.getStationData(id);
        if(station == null) {
            throw new Exception();
        }
        return ResponseEntity.status(HttpStatus.OK)
            .body(station);
    }

    @RequestMapping(
        value = "/station/{id}",
        method={RequestMethod.POST, RequestMethod.PATCH}, 
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<StationDto> updateStation(
        @PathVariable int id,
        @RequestBody StationDto stationDto
    ) {
        StationDto updatedStation = stationService.updateStation(stationDto);
        return ResponseEntity.status(HttpStatus.OK)
            .body(updatedStation);
    }
}
