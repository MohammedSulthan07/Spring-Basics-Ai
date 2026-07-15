package com.hibernate.util;

import com.hibernate.dto.DomesticPetDTO;
import com.hibernate.dto.OwnerDTO;
import com.hibernate.dto.WildPetDTO;
import com.hibernate.entity.DomesticPet;
import com.hibernate.entity.Owner;
import com.hibernate.entity.WildPet;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-15T14:28:06+0530",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24.0.1 (Oracle Corporation)"
)
@Component
public class PetMapperImpl implements PetMapper {

    @Override
    public WildPetDTO wildPetToWildPetDTO(WildPet wildPet) {
        if ( wildPet == null ) {
            return null;
        }

        WildPetDTO wildPetDTO = new WildPetDTO();

        wildPetDTO.setOwnerDTO( ownerToOwnerDTO( wildPet.getOwner() ) );
        wildPetDTO.setId( wildPet.getId() );
        wildPetDTO.setName( wildPet.getName() );
        wildPetDTO.setGender( wildPet.getGender() );
        wildPetDTO.setType( wildPet.getType() );
        wildPetDTO.setBirthPlace( wildPet.getBirthPlace() );

        return wildPetDTO;
    }

    @Override
    public DomesticPetDTO domesticPetToDomesticPetDTO(DomesticPet domesticPet) {
        if ( domesticPet == null ) {
            return null;
        }

        DomesticPetDTO domesticPetDTO = new DomesticPetDTO();

        domesticPetDTO.setOwnerDTO( ownerToOwnerDTO( domesticPet.getOwner() ) );
        domesticPetDTO.setId( domesticPet.getId() );
        domesticPetDTO.setName( domesticPet.getName() );
        domesticPetDTO.setGender( domesticPet.getGender() );
        domesticPetDTO.setType( domesticPet.getType() );
        domesticPetDTO.setBirthDate( domesticPet.getBirthDate() );

        return domesticPetDTO;
    }

    protected OwnerDTO ownerToOwnerDTO(Owner owner) {
        if ( owner == null ) {
            return null;
        }

        OwnerDTO ownerDTO = new OwnerDTO();

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
}
