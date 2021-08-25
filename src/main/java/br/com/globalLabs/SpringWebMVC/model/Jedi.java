package br.com.globalLabs.SpringWebMVC.model;

import javax.validation.constraints.NotBlank;

public class Jedi {

	@NotBlank(message = "Required field!")
	private String name;
	@NotBlank(message = "Required field!")
	private String lastName;

	public Jedi(final String name, final String lastName) {
		this.name = name;
		this.lastName = lastName;
	}

	public Jedi() {

	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
