package com.example.hibernateplayground.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hibernateplayground.model.Station;

@Repository
public interface StationRepository extends JpaRepository<Station, Integer>{
    Optional<Station> findById(int id);

    int deleteById(int id);
}
