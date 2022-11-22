package com.example.hibernateplayground.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.hibernateplayground.model.BranchStation;

@Repository
public interface BranchStationRepository extends JpaRepository<BranchStation, Integer> {
    Optional<BranchStation> findById(int id);
    
    @Query(value = "select b.branchId from BranchStation b WHERE b.id = :id")
    Integer findBranchIdById(int id);
    
    @Query(value = "select b.id from BranchStation b WHERE b.branchId = :branchId")
    Integer findIdByBranchId(int branchId);

    int deleteById(int id);
}
