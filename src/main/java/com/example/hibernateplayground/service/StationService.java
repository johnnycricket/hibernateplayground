package com.example.hibernateplayground.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hibernateplayground.dto.StationDto;
import com.example.hibernateplayground.mappers.StationMapper;
import com.example.hibernateplayground.model.BranchStation;
import com.example.hibernateplayground.model.Station;
import com.example.hibernateplayground.repositories.BranchStationRepository;
import com.example.hibernateplayground.repositories.StationRepository;

@Service
public class StationService {
    private final StationRepository repository;
    private final StationMapper mapper;
    private final BranchStationRepository branchStationRepository;

    @Autowired
    public StationService(
        StationRepository repository,
        StationMapper mapper,
        BranchStationRepository branchStationRepository
    ){
        this.repository = repository;
        this.mapper = mapper;
        this.branchStationRepository = branchStationRepository;
    };

    public StationDto getStationData(int stationId) {
        Optional<Station> optionalStation = repository.findById(stationId);

        if(optionalStation.isEmpty()){
            return null;
        }

        return mapper.toDto(optionalStation.get());
    }

    public StationDto updateStation(StationDto stationDto) {
        Optional<Station> optionalStation = repository.findById(stationDto.getId());
        
        if(optionalStation == null){
            return null;
        }

        Station station = optionalStation.get();
        // mapper.updateStationFromDto(stationDto, station);
        mapper.update(stationDto, station);

        repository.save(station);

        return mapper.toDto(station);
    }
};
