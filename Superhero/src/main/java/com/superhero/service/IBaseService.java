package com.superhero.service;

import java.util.List;
import java.util.Optional;

import com.superhero.model.entity.SuperHero;

public interface IBaseService {

	public List<SuperHero> getSuperHeros();
	public Optional<SuperHero> getSuperHero(Long id);
	public List<SuperHero> getSuperHeroByName(String name);
	public void deleteSuperHero(Long id);
	public List<SuperHero> getSuperHeroByNameLike(String name);
	public void save(SuperHero superHero);	
}
