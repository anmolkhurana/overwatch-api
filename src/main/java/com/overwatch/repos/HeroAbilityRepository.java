package com.overwatch.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.overwatch.domain.HeroAbility;

public interface HeroAbilityRepository extends PagingAndSortingRepository<HeroAbility, Long>{
	Page<HeroAbility> findById(Long Id, Pageable pageable);
}
