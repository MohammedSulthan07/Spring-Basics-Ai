package com.hibernate.entity;


import com.hibernate.enums.Gender;
import com.hibernate.enums.PetType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "pet_table")
public class Pet extends Base{

//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Id
//	private int id;
	@Column(nullable = false)
	private String name;
	@Enumerated(value = EnumType.STRING)
	@Column(nullable = false)
	private Gender gender;
	@Enumerated(value = EnumType.STRING)
	@Column(nullable = false)
	private PetType type;
	@OneToOne(mappedBy = "pet")
	private Owner owner;


}
