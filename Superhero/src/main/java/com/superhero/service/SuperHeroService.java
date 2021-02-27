package com.superhero.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.superhero.dao.BaseModelDAO;
import com.superhero.dao.CustomSuperHeroDAO;
import com.superhero.model.entity.SuperHero;

@Service
public class SuperHeroService implements IBaseService{

	
	@Autowired
	private BaseModelDAO baseModelDAO;
	
	@Autowired
	private CustomSuperHeroDAO customSuperHeroDAO;
	
	
	@Override
	public List<SuperHero> getSuperHeros() {
		return (List<SuperHero>) baseModelDAO.findAll();
	}
	
	@Override
	public Optional<SuperHero> getSuperHero(Long id) {
		return  baseModelDAO.findById(id);
	}

	@Override
	public List<SuperHero> getSuperHeroByName(String name) {
		return baseModelDAO.findByname(name);
	}

	@Override
	public void deleteSuperHero(Long id) {
		baseModelDAO.deleteById(id);
	}
	
	@Override
	public List<SuperHero> getSuperHeroByNameLike(String name) {
		return (List<SuperHero>) customSuperHeroDAO.findByLikeName(name);

	}
	
	@Override
	public void save(SuperHero superHero) {
		baseModelDAO.save(superHero);
	}
	
}
