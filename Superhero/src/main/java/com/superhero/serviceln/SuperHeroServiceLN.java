package com.superhero.serviceln;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.superhero.model.entity.SuperHero;
import com.superhero.model.response.Response;
import com.superhero.model.response.message.ErrorMessage;
import com.superhero.model.response.message.ErrorMessage.EDescription;
import com.superhero.service.SuperHeroService;

@Service
public class SuperHeroServiceLN {

	
	@Autowired
	private SuperHeroService superHeroService;
	
	public Response getSuperHeros() {
		ErrorMessage errorMessage = null;
		List<SuperHero> superHeros = superHeroService.getSuperHeros();
		boolean result = true;
		
		if(superHeros==null) {
			errorMessage = new ErrorMessage(EDescription.ERROR);
			result = false;
		}
		
		Response response = new Response(superHeros,errorMessage,result);
		return response;
	}
	
	
	public Response getSuperHero(Long id) {
		List<SuperHero> superHeros = null;
		ErrorMessage errorMessage = null;
		boolean result = true;
		
		if(id!=null) {
			Optional<SuperHero> superHero = superHeroService.getSuperHero(id);
			
			if(superHero.isPresent()) {
				superHeros = Arrays.asList(superHero.get());
			}else {
				errorMessage = new ErrorMessage(EDescription.NOT_FOUND);
				result =false;
			}
		}else {
			errorMessage = new ErrorMessage(EDescription.NO_VALUE);
			result =false;
		}
		
		Response response = new Response(superHeros,errorMessage,result);
		return  response;
	}

	
	public Response getSuperHeroByName(String name) {
		List<SuperHero> superHeros = null;
		ErrorMessage errorMessage = null;
		boolean result = true;
		
		if(name!=null && !name.isEmpty()) {
			superHeros =  superHeroService.getSuperHeroByName(name);
			
			if(superHeros==null || superHeros.isEmpty()) {
				errorMessage = new ErrorMessage(EDescription.NOT_FOUND);
				result = false;
			}
		}else {
			errorMessage = new ErrorMessage(EDescription.NO_VALUE);
			result =false;
		}
		
		Response response = new Response(superHeros,errorMessage,result);
		return response;
	}

	
	public Response deleteSuperHero(Long id) {	
		List<SuperHero> superHeros = null;
		ErrorMessage errorMessage = null;
		boolean result = true;
		
		if(id!=null) {
			superHeroService.deleteSuperHero(id);
			Optional<SuperHero> superHero  = superHeroService.getSuperHero(id);
			if(superHero!=null && !superHero.isEmpty()) {
				errorMessage = new ErrorMessage(EDescription.NOT_FOUND);
				result =  false;
			}
			
		}else {
			errorMessage = new ErrorMessage(EDescription.NO_VALUE);
			result =  false;
		}
		
		Response response = new Response(superHeros,errorMessage,result);
		return  response;
	}
	
	public Response getSuperHeroByNameLike(String name) {
		List<SuperHero> superHeros = null;
		ErrorMessage errorMessage = null;
		boolean result = true;
		
		if(name!=null && !name.isEmpty()) {
			superHeros =  superHeroService.getSuperHeroByNameLike(name);
			
			if(superHeros==null || superHeros.isEmpty()) {
				errorMessage = new ErrorMessage(EDescription.NOT_FOUND);
				result = false;
			}
		}else {
			errorMessage = new ErrorMessage(EDescription.NO_VALUE);
			result =false;
		}
				
		Response response = new Response(superHeros,errorMessage,result);
		return  response;

	}
	
	public Response changeSuperHeroDescription(Long id, String newDescription) {
		List<SuperHero> superHeros = null;
		ErrorMessage errorMessage = null;
		boolean result = true;
		
		
		if(id!=null && newDescription!=null && !newDescription.isEmpty()) {
			Optional<SuperHero> superHeroAuxBD = superHeroService.getSuperHero(id);
			if(superHeroAuxBD.isPresent()) {
				SuperHero superHeroBD = superHeroAuxBD.get();
				superHeroBD.setDescription(newDescription);
				superHeroService.save(superHeroBD);
				
				superHeros = Arrays.asList(superHeroBD);
			}else {
				errorMessage = new ErrorMessage(EDescription.NOT_FOUND);
				result = false;
			}
		}else {
			errorMessage = new ErrorMessage(EDescription.NO_VALUE);
			result =false;
		}
		
		Response response = new Response(superHeros,errorMessage,result);
		return  response;

	}
	
}
