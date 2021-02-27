package com.superhero.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.superhero.annotation.LogTime;
import com.superhero.model.response.Response;
import com.superhero.serviceln.SuperHeroServiceLN;

@RestController
@RequestMapping (value="superheros")
public class SuperHeroController {
	
	@Autowired
	private SuperHeroServiceLN superHeroServiceLN;
	
	@LogTime
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public Response getSuperHeros() {
		return superHeroServiceLN.getSuperHeros();
	}
	
	@LogTime
	@RequestMapping(value="/view/{id}", method=RequestMethod.GET)
	public Response getSuperHero(@PathVariable("id") Long id, HttpServletRequest request) {
		return superHeroServiceLN.getSuperHero(id);
	}
	
	@LogTime
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public Response deleteSuperHero(@PathVariable("id") Long id, HttpServletRequest request) {	
		return superHeroServiceLN.deleteSuperHero(id);
	}
	
	@LogTime
	@RequestMapping(value="/view-by-name/{name}", method=RequestMethod.GET)
	public Response getSuperHeroByName(@PathVariable("name") String name, HttpServletRequest request) {
		return superHeroServiceLN.getSuperHeroByName(name);
	}
	
	@LogTime
	@RequestMapping(value="/view-like/{name}", method=RequestMethod.GET)
	public Response getSuperHeroByNameLike(@PathVariable("name") String name, HttpServletRequest request) {	
		return superHeroServiceLN.getSuperHeroByNameLike(name);		
	}
	
	@LogTime
	@RequestMapping(value="/change-description/{id}/{newDescription}", method=RequestMethod.GET)
	public Response changeSuperHeroDescription(@PathVariable("id") Long id,@PathVariable("newDescription") String newDescription, HttpServletRequest request) {
		return superHeroServiceLN.changeSuperHeroDescription(id,newDescription);		
	}
}
