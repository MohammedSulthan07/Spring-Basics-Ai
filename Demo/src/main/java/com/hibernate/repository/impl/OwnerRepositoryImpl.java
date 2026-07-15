package com.hibernate.repository.impl;

import com.hibernate.entity.Owner;
import com.hibernate.entity.Pet;
import com.hibernate.exception.OwnerNotFoundException;
import com.hibernate.repository.OwnerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OwnerRepositoryImpl implements OwnerRepository {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public void save(Owner owner) {
		try(EntityManager em=entityManagerFactory.createEntityManager()){
			em.getTransaction().begin();
			em.persist(owner);
			em.getTransaction().commit();
		}
	}

	@Override
	public Optional<Owner> findById(int ownerId) {
		try(EntityManager em=entityManagerFactory.createEntityManager()){
			Owner owner=em.find(Owner.class,ownerId);
			return Optional.of(owner);
		}
	}

	@Override
	public void updatePetDetails(int ownerId, String petName) {
		try (EntityManager em = entityManagerFactory.createEntityManager()) {
			em.getTransaction().begin();
			Owner owner = em.find(Owner.class, ownerId);
			if (owner != null && owner.getPet() != null) {
				owner.getPet().setName(petName);
			}
			em.merge(owner);
			em.getTransaction().commit();
		}
	}

	@Override
	public void deleteById(int ownerId) {
		try (EntityManager em = entityManagerFactory.createEntityManager()){
			em.getTransaction().begin();
			Owner owner = em.find(Owner.class, ownerId);
			em.remove(owner);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Owner_Not_Found");
		}
	}

	@Override
	public List<Owner> findAll() {
		throw new UnsupportedOperationException("Fetching all owners is not supported.");
	}
}

