package com.overwatch.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.overwatch.dao.HeroAbilityDao;
import com.overwatch.domain.HeroAbility;
import com.overwatch.domain.HeroData;
import com.overwatch.repos.HeroAbilityRepository;

@RestController
@RequestMapping("/overwatch")
public class HeroAbilityController {
	
	@Autowired
	HeroAbilityDao heroAbilityDao;
	
	@Autowired
	HeroAbilityRepository heroAbilityRepository;
	
	@PostMapping("/api/hero/ability/create")
	public HeroAbility createHero(@Valid @RequestBody HeroAbility heroAbility) {
		return heroAbilityDao.save(heroAbility);
	}
	
	@GetMapping("/api/hero/ability/retAbilities")
	public Page<HeroAbility> getAllHerosAbilities(Pageable pageable){
		return heroAbilityDao.getAllHerosAbility(pageable);
	}
	
	@GetMapping("/api/hero/retreiveherosAbility/{Id}")
	public Page<HeroAbility> getAllHeroAbilityById(@PathVariable (value = "Id") Long Id, Pageable pageable){
		return heroAbilityRepository.findById(Id, pageable);
	}
}
