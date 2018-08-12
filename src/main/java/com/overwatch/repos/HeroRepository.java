package com.overwatch.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.overwatch.domain.Hero;

public interface HeroRepository extends PagingAndSortingRepository<Hero, Long>{
	
}
