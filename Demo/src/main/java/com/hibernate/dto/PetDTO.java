package com.hibernate.dto;

import java.util.Objects;

import com.hibernate.enums.Gender;
import com.hibernate.enums.PetType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PetDTO {
	private int id;
	private String name;
	private Gender gender;
	private PetType type;
	private OwnerDTO ownerDTO;


}
