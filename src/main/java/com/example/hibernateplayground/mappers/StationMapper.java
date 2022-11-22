package com.example.hibernateplayground.mappers;

import org.mapstruct.*;

import com.example.hibernateplayground.dto.StationDto;
import com.example.hibernateplayground.model.Station;

@Mapper(
    uses = JsonNullableMapper.class,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    componentModel = "spring"
)
public interface StationMapper {
    StationDto toDto(Station station);

    Station toEntity(StationDto stationDto);

    // @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    // void updateStationFromDto(StationDto stationDto, @MappingTarget Station entity);

    @InheritConfiguration
    @Mapping(target = "id", ignore = true)
    void update(StationDto update, @MappingTarget Station destination);
}
