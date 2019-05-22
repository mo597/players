package com.fr.adaming.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class UserDto {
	
	private Long id;
	private String name;
	private String firstname;
	
	@Min(value = 13)
	private Integer age;
	
	@Email
	@NotNull
	private String email;
	
	@NotNull
	private String pwd;

}
