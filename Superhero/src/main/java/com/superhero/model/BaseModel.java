package com.superhero.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value  = Include.NON_EMPTY)
public class BaseModel  implements Serializable{

	private static final long serialVersionUID = 4892617393972372812L;
	

}
