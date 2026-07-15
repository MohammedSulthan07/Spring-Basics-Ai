package com.hibernate.repository;

import com.hibernate.entity.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository {

	void save(Owner owner);

	Optional<Owner> findById(int ownerId);

	void updatePetDetails(int ownerId, String petName);

	void deleteById(int ownerId);

	List<Owner> findAll();
}
