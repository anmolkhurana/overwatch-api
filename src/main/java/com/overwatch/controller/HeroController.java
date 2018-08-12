package com.overwatch.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.overwatch.dao.HeroDao;
import com.overwatch.domain.Hero;

@RestController
@RequestMapping("/overwatch")
public class HeroController {
	@Autowired
	HeroDao heroDao;
	
	@RequestMapping(value = "/api/hero/create", method = RequestMethod.POST, consumes = { "application/json",
	"application/xml" }, produces = { "application/json", "application/xml" })
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody void createExperience(@RequestBody Hero hero, HttpServletRequest request, HttpServletResponse response) {
		Hero createHero = this.heroDao.save(hero);
		response.setHeader("Hero", request.getRequestURL().append("/").append(createHero.getId()).toString());
	}
	
	/*
	@PostMapping("/create")
	public Hero createHero(@Valid @RequestBody Hero hero) {
		return heroDao.save(hero);
	}*/
	
	@GetMapping("/api/hero/retHeros")
	public Page<Hero> getAllHeros(Pageable pageable){
		return heroDao.getAllHeros(pageable);
	}
}
