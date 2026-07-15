package com.hibernate.service.impl;

import com.hibernate.dto.PetDTO;
import com.hibernate.exception.OwnerNotFoundException;
import com.hibernate.exception.PetNotFoundException;
import com.hibernate.repository.PetRepository;
import com.hibernate.service.PetService;
import com.hibernate.util.PetMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PetServiceImpl implements PetService {

	private final PetRepository petRepository;
	private final PetMapper petMapper;

	@Value("${pet.not.found}")
	private static String PET_NOT_FOUND;

	@Override
	public PetDTO findPet(int petId) throws PetNotFoundException {
		return petRepository.findById(petId).map(petMapper::toPetDTO).orElseThrow(()->new PetNotFoundException(String.format(PET_NOT_FOUND,petId)));
	}
}