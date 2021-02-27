package com.superhero.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.superhero.model.entity.SuperHero;

public interface BaseModelDAO  extends CrudRepository<SuperHero, Long>{

	public List<SuperHero> findByname(String name);
}
