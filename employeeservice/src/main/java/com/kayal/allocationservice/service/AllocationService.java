package com.kayal.allocationservice.service;

import java.util.List;
import java.util.Optional;

import com.kayal.allocationservice.model.Allocation;

public interface AllocationService {

	Allocation createAllocation(Allocation allocation);

	List<Allocation> getAllocations();

	Optional<Allocation> getAllocationById(Integer id);

	Allocation updateAllocation(Allocation allocation, Integer id);

	void deleteAllocation(Integer id);

}