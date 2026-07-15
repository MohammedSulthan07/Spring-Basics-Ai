package com.hibernate.util;

import com.hibernate.dto.DomesticPetDTO;
import com.hibernate.dto.OwnerDTO;
import com.hibernate.dto.PetDTO;
import com.hibernate.dto.WildPetDTO;
import com.hibernate.entity.DomesticPet;
import com.hibernate.entity.Owner;
import com.hibernate.entity.WildPet;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-15T14:36:20+0530",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24.0.1 (Oracle Corporation)"
)
@Component
public class OwnerMapperImpl implements OwnerMapper {

    @Override
    public Owner toEntity(OwnerDTO ownerDTO) {
        if ( ownerDTO == null ) {
            return null;
        }

        Owner owner = new Owner();

        owner.setPet( toEntity( ownerDTO.getPetDTO() ) );
        owner.setId( ownerDTO.getId() );
        owner.setFirstName( ownerDTO.getFirstName() );
        owner.setLastName( ownerDTO.getLastName() );
        owner.setGender( ownerDTO.getGender() );
        owner.setCity( ownerDTO.getCity() );
        owner.setState( ownerDTO.getState() );
        owner.setMobileNumber( ownerDTO.getMobileNumber() );
        owner.setEmailId( ownerDTO.getEmailId() );

        return owner;
    }

    @Override
    public WildPet wildPetPetDTOtoEntity(WildPetDTO wildPetDTO) {
        if ( wildPetDTO == null ) {
            return null;
        }

        WildPet wildPet = new WildPet();

        wildPet.setId( wildPetDTO.getId() );
        wildPet.setName( wildPetDTO.getName() );
        wildPet.setGender( wildPetDTO.getGender() );
        wildPet.setType( wildPetDTO.getType() );
        wildPet.setBirthPlace( wildPetDTO.getBirthPlace() );

        return wildPet;
    }

    @Override
    public DomesticPet domesticPetDTOtoEntity(DomesticPetDTO domesticPetDTO) {
        if ( domesticPetDTO == null ) {
            return null;
        }

        DomesticPet domesticPet = new DomesticPet();

        domesticPet.setId( domesticPetDTO.getId() );
        domesticPet.setName( domesticPetDTO.getName() );
        domesticPet.setGender( domesticPetDTO.getGender() );
        domesticPet.setType( domesticPetDTO.getType() );
        domesticPet.setBirthDate( domesticPetDTO.getBirthDate() );

        return domesticPet;
    }

    @Override
    public OwnerDTO toDTO(Owner owner) {
        if ( owner == null ) {
            return null;
        }

        OwnerDTO ownerDTO = new OwnerDTO();

        ownerDTO.setPetDTO( toDTO( owner.getPet() ) );
        ownerDTO.setId( owner.getId() );
        ownerDTO.setFirstName( owner.getFirstName() );
        ownerDTO.setLastName( owner.getLastName() );
        ownerDTO.setGender( owner.getGender() );
        ownerDTO.setCity( owner.getCity() );
        ownerDTO.setState( owner.getState() );
        ownerDTO.setMobileNumber( owner.getMobileNumber() );
        ownerDTO.setEmailId( owner.getEmailId() );

        return ownerDTO;
    }

    @Override
    public PetDTO domesticPetEntityToDTO(DomesticPet domesticPet) {
        if ( domesticPet == null ) {
            return null;
        }

        PetDTO petDTO = new PetDTO();

        petDTO.setId( domesticPet.getId() );
        petDTO.setName( domesticPet.getName() );
        petDTO.setGender( domesticPet.getGender() );
        petDTO.setType( domesticPet.getType() );

        return petDTO;
    }

    @Override
    public PetDTO wildPetPetDTOEntityToDTO(WildPet wildPet) {
        if ( wildPet == null ) {
            return null;
        }

        PetDTO petDTO = new PetDTO();

        petDTO.setId( wildPet.getId() );
        petDTO.setName( wildPet.getName() );
        petDTO.setGender( wildPet.getGender() );
        petDTO.setType( wildPet.getType() );

        return petDTO;
    }
}
