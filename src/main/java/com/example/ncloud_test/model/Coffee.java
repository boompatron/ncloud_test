package com.example.ncloud_test.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "Coffee")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Coffee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private Integer cost;

	private String description;

	@Builder
	public Coffee(Long id, String name, Integer cost, String description) {
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.description = description;
	}

	public static Coffee toCoffee(CoffeeDto dto){
		return Coffee.builder()
				.id(dto.id())
				.name(dto.name())
				.cost(dto.cost())
				.description(dto.description())
				.build();
	}

	public static CoffeeDto toDto(Coffee coffee) {
		return new CoffeeDto(
				coffee.getId(),
				coffee.getName(),
				coffee.getCost(),
				coffee.getDescription()
		);
	}
}
