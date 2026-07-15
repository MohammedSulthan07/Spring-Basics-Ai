package com.hibernate.util;

import com.hibernate.dto.DomesticPetDTO;
import com.hibernate.dto.PetDTO;
import com.hibernate.dto.WildPetDTO;
import com.hibernate.entity.DomesticPet;
import com.hibernate.entity.Pet;
import com.hibernate.entity.WildPet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PetMapper {
    default PetDTO toPetDTO(Pet pet){
        return switch (pet){
            case DomesticPet domesticPet->domesticPetToDomesticPetDTO(domesticPet);
            case WildPet wildPet-> wildPetToWildPetDTO(wildPet);
            default -> throw new IllegalArgumentException("Unknown pet type");
        };
    }
    @Mapping(target = "ownerDTO.petDTO",ignore = true)
    @Mapping(source = "owner",target = "ownerDTO")
    WildPetDTO wildPetToWildPetDTO(WildPet wildPet);

    @Mapping(target = "ownerDTO.petDTO",ignore = true)
    @Mapping(source = "owner",target = "ownerDTO")
    DomesticPetDTO domesticPetToDomesticPetDTO(DomesticPet domesticPet);
}
