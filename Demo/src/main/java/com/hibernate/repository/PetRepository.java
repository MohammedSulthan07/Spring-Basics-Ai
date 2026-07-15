package com.hibernate.repository;

import com.hibernate.entity.Pet;

import java.util.Optional;

public interface PetRepository {
	Optional<Pet> findById(int petId);
}
