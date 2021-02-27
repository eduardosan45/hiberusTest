package com.superhero.model.response;

import java.util.List;

import com.superhero.model.BaseModel;
import com.superhero.model.entity.SuperHero;
import com.superhero.model.response.message.ErrorMessage;

public class Response extends BaseModel{

	
	private static final long serialVersionUID = -6761051989784628305L;
	
	private List<SuperHero> superHeros;	 
	private ErrorMessage errorMesssage;
	private boolean result;
	
	public Response() {
		super();
	}
	
	public Response(List<SuperHero> superHeros,ErrorMessage errorMessage, boolean result) {
		super();
		this.superHeros= superHeros;
		this.errorMesssage = errorMessage;
		this.result = result;
	}
	
	public List<SuperHero> getSuperHeros() {
		return superHeros;
	}
	
	public void setSuperHeros(List<SuperHero> superHeros) {
		this.superHeros = superHeros;
	}
	
	public ErrorMessage getErrorMesssage() {
		return errorMesssage;
	}
	
	public void setErrorMesssage(ErrorMessage errorMesssage) {
		this.errorMesssage = errorMesssage;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}	

}
