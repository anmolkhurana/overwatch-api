package com.overwatch.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.overwatch.domain.HeroAbility;

public interface HeroAbilityRepository extends PagingAndSortingRepository<HeroAbility, Long>{

}
