package com.hibernate.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Objects;


@Getter
@Setter
@ToString
public class DomesticPetDTO extends PetDTO  {
	private LocalDate birthDate;
}
