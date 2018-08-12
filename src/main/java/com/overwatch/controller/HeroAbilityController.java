package com.overwatch.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.overwatch.dao.HeroAbilityDao;
import com.overwatch.domain.HeroAbility;

@RestController
@RequestMapping("/overwatch")
public class HeroAbilityController {
	
	@Autowired
	HeroAbilityDao heroAbilityDao;
	
	@PostMapping("/api/hero/ability/create")
	public HeroAbility createHero(@Valid @RequestBody HeroAbility heroAbility) {
		return heroAbilityDao.save(heroAbility);
	}
}
