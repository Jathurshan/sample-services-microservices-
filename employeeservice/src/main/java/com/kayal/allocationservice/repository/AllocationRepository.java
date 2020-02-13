package com.kayal.allocationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kayal.allocationservice.model.Allocation;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Integer> {
}
