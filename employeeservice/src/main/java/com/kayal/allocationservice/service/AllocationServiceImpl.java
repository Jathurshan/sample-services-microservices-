package com.kayal.allocationservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kayal.allocationservice.model.Allocation;
import com.kayal.allocationservice.repository.AllocationRepository;

@Service
public class AllocationServiceImpl implements AllocationService {

	@Autowired
	AllocationRepository allocationRepository;

	@Override
	public Allocation createAllocation(Allocation allocation) {
		return allocationRepository.save(allocation);
	}

	@Override
	public List<Allocation> getAllocations() {
		return allocationRepository.findAll();
	}

	@Override
	public Optional<Allocation> getAllocationById(Integer id) {
		return allocationRepository.findById(id);
	}

	@Override
	public Allocation updateAllocation(Allocation allocation, Integer id) {
		Optional<Allocation> allocatinEntity = allocationRepository.findById(id);

		Allocation updatedEntity = new Allocation();

		if (allocatinEntity.isPresent()) {
			updatedEntity.setId(id);
			updatedEntity.setEmpId(allocation.getEmpId());
			updatedEntity.setStart(allocation.getStart());
			updatedEntity.setEnd(allocation.getEnd());
			updatedEntity.setProjectCode(allocation.getProjectCode());

			return allocationRepository.save(updatedEntity);
		}
		return null;
	}

	@Override
	public void deleteAllocation(Integer id) {
		allocationRepository.deleteById(id);
	}
}
