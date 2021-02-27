package com.superhero.model.response.message;

import com.superhero.model.BaseModel;

public class ErrorMessage extends BaseModel{

	private static final long serialVersionUID = 2707097201041646303L;
	
	public ErrorMessage() {
		super();
	}
	public ErrorMessage(EDescription description) {
		super();
		this.description = description;
	}
	public ErrorMessage(EDescription description,String info) {
		super();
		this.description = description;
		this.info = info;
	}
	
	private EDescription description;
	private String info;
	
	
	public EDescription getDescription() {
		return description;
	}
	public void setDescription(EDescription description) {
		this.description = description;
	}
	
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	public String getDescriptionStr() {
		if(description!=null) {
			return description.getDescription();
		}
		return "";
	}



	public enum EDescription{
		ERROR("General error"),
		NOT_FOUND("Object not found"),
		NO_VALUE("No value present");
		
		private String description;
		
		private EDescription(String description) {
			this.description = description;
		}

		public String getDescription() {
			return description;
		}

	}
	

}
