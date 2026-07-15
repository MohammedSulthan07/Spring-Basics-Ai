package com.hibernate.util;


import com.hibernate.dto.DomesticPetDTO;
import com.hibernate.dto.OwnerDTO;
import com.hibernate.dto.PetDTO;
import com.hibernate.dto.WildPetDTO;
import com.hibernate.entity.DomesticPet;
import com.hibernate.entity.Owner;
import com.hibernate.entity.Pet;
import com.hibernate.entity.WildPet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OwnerMapper {

    @Mapping(source="petDTO",target="pet")
    Owner toEntity(OwnerDTO ownerDTO);

    default Pet toEntity(PetDTO petDTO) {
        return switch (petDTO){
            case DomesticPetDTO domesticPetDTO->
                    domesticPetDTOtoEntity(domesticPetDTO);
            case WildPetDTO wildPetDTO ->
                    wildPetPetDTOtoEntity(wildPetDTO);
            default ->
                    throw new IllegalArgumentException("Unknown pet type");
        };
    }

    @Mapping(target="owner",ignore = true)
    WildPet wildPetPetDTOtoEntity(WildPetDTO wildPetDTO);

    @Mapping(target="owner",ignore = true)
    DomesticPet domesticPetDTOtoEntity(DomesticPetDTO domesticPetDTO);

    @Mapping(source="pet",target="petDTO")
    OwnerDTO toDTO(Owner owner);

    default PetDTO toDTO(Pet pet) {
        return switch (pet){
            case DomesticPet domesticPet->
                    domesticPetEntityToDTO(domesticPet);
            case WildPet wildPet ->
                    wildPetPetDTOEntityToDTO(wildPet);
            default ->
                    throw new IllegalArgumentException("Unknown pet type");
        };
    }

    @Mapping(target ="ownerDTO",ignore = true)
    PetDTO domesticPetEntityToDTO(DomesticPet domesticPet);

    @Mapping(target = "ownerDTO",ignore = true)
    PetDTO wildPetPetDTOEntityToDTO(WildPet wildPet);

}
