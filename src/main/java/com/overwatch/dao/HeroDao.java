package com.overwatch.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.overwatch.domain.Hero;
import com.overwatch.repos.HeroRepository;

@Service
public class HeroDao {
	
	@Autowired
	HeroRepository heroRepository;
	
	public Hero save(Hero hero) {
		return heroRepository.save(hero);
	}
	
	public Page<Hero> getAllHeros(Pageable pageable){
		return heroRepository.findAll(pageable);
	}
}
