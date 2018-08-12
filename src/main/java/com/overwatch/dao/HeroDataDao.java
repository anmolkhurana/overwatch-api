package com.overwatch.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.overwatch.domain.HeroData;
import com.overwatch.repos.HeroDataRepository;

@Service
public class HeroDataDao {
	
	@Autowired
	HeroDataRepository heroDataRepository;
	
	public HeroData save(HeroData heroData) {
		return heroDataRepository.save(heroData);
	}
	
	public List<HeroData> findAll(){
		return heroDataRepository.findAll();
	}
}
