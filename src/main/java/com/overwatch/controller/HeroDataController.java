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

import com.overwatch.dao.HeroDataDao;
import com.overwatch.domain.HeroData;
import com.overwatch.repos.HeroDataRepository;

@RestController
@RequestMapping("/overwatch")
public class HeroDataController {
	@Autowired
	HeroDataDao heroDataDao;
	
	@Autowired
	HeroDataRepository heroDataRepository;
	
	@PostMapping("/createHeroData")
	public HeroData createHero(@Valid @RequestBody HeroData heroData) {
		return heroDataDao.save(heroData);
	}
	
	@GetMapping("/api/hero/retreiveheros/{heroId}")
	public Page<HeroData> getAllHeroDatasByHeroId(@PathVariable (value = "heroId") Long heroId, Pageable pageable){
		return heroDataRepository.findByHeroId(heroId, pageable);
	}
}
