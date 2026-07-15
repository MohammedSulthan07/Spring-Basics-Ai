package com.hibernate.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;


@Getter
@Setter
@ToString
public class WildPetDTO extends PetDTO {
	private String birthPlace;

}

