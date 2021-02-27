package com.superhero.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.superhero.model.entity.SuperHero;

@Repository
public class CustomSuperHeroDAO {

	@Autowired
	private EntityManager em;


    public List<SuperHero> findByLikeName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SuperHero> cq = cb.createQuery(SuperHero.class);

        Root<SuperHero> superHero = cq.from(SuperHero.class);
        Predicate titlePredicate = cb.like(cb.upper(superHero.get("name")), "%" + name.toUpperCase() + "%");
        cq.where(titlePredicate);

        TypedQuery<SuperHero> query = em.createQuery(cq);
        return query.getResultList();
    }
}
