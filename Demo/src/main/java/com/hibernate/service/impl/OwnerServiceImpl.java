package com.hibernate.service.impl;


import com.hibernate.dto.OwnerDTO;
import com.hibernate.entity.Owner;
import com.hibernate.exception.OwnerNotFoundException;
import com.hibernate.repository.OwnerRepository;
import com.hibernate.service.OwnerService;
import com.hibernate.util.OwnerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OwnerServiceImpl implements OwnerService {

	private final OwnerRepository ownerRepository;
	private final OwnerMapper ownerMapper;

	@Value("${owner.not.found}")
	private static String OWNER_NOT_FOUND;

	@Override
	public void saveOwner(OwnerDTO ownerDTO) {
		Owner owner=ownerMapper.toEntity(ownerDTO);
		ownerRepository.save(owner);
	}

	@Override
	public OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException {
		return ownerRepository.findById(ownerId).map(ownerMapper::toDTO).orElseThrow(()->new OwnerNotFoundException(String.format(OWNER_NOT_FOUND,ownerId)));
	}

	@Override
	public void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException {
		Optional<Owner> optionalOwner = ownerRepository.findById(ownerId);
		if (optionalOwner.isEmpty()) {
			throw new OwnerNotFoundException("ownerNotFound");
		}
		ownerRepository.updatePetDetails(ownerId, petName);
	}

	@Override
	public void deleteOwner(int ownerId) throws OwnerNotFoundException {
		Optional<Owner> optionalOwner = ownerRepository.findById(ownerId);
		ownerRepository.deleteById(ownerId);
	}

	@Override
	public List<OwnerDTO> findAllOwners() {
		return null;
	}
}
