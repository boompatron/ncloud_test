package com.example.ncloud_test.service;

import static com.example.ncloud_test.model.Coffee.toCoffee;
import static com.example.ncloud_test.model.Coffee.toDto;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ncloud_test.model.Coffee;
import com.example.ncloud_test.model.CoffeeDto;
import com.example.ncloud_test.repository.CoffeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CoffeeService {

	private final CoffeeRepository coffeeRepository;

	@Transactional
	public Long registerCoffee(CoffeeDto dto) {
		return coffeeRepository.save(toCoffee(dto)).getId();
	}

	@Transactional(readOnly = true)
	public CoffeeDto getCoffee(Long id) {
		return toDto(getEntity(id));
	}

	private Coffee getEntity(Long id){
		return coffeeRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("No Entity"));
	}
}
