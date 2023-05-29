package com.example.ncloud_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ncloud_test.model.Coffee;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
