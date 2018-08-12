package com.overwatch.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.overwatch.domain.HeroAbility;
import com.overwatch.repos.HeroAbilityRepository;

@Service
public class HeroAbilityDao {
	
	@Autowired
	HeroAbilityRepository heroAbilityRepository;
	
	public HeroAbility save(HeroAbility heroAbility) {
		return heroAbilityRepository.save(heroAbility);
	}
	
	public Page<HeroAbility> getAllHerosAbility(Pageable pageable){
		return heroAbilityRepository.findAll(pageable);
	}
}
