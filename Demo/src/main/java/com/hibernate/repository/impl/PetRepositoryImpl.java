package com.hibernate.repository.impl;

import com.hibernate.entity.Owner;
import com.hibernate.entity.Pet;
import com.hibernate.repository.PetRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PetRepositoryImpl implements PetRepository {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public Optional<Pet> findById(int petId) {
		try(EntityManager em=entityManagerFactory.createEntityManager()){
			Pet pet=em.find(Pet.class,petId);
			return Optional.of(pet);
		}
	}

}
