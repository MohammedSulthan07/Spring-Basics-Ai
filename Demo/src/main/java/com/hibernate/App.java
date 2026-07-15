package com.hibernate;

import java.util.List;
import java.util.Scanner;

import com.hibernate.dto.OwnerDTO;
import com.hibernate.dto.PetDTO;
import com.hibernate.service.OwnerService;
import com.hibernate.service.PetService;
import com.hibernate.service.impl.OwnerServiceImpl;
import com.hibernate.service.impl.PetServiceImpl;
import com.hibernate.util.InputUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:messages.properties")
@RequiredArgsConstructor
@SpringBootApplication
public class App implements CommandLineRunner {

    private final OwnerService ownerService;
    private final PetService petService;

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.println("Welcome to Petistaan");
                int menuOption = InputUtil.acceptMenuOption(scanner);
                switch (menuOption) {
                    case 1:
                        OwnerDTO ownerDTO = InputUtil.acceptOwnerDetailsToSave(scanner);
                        PetDTO petDTO = InputUtil.acceptPetDetailsToSave(scanner);
                        ownerDTO.setPetDTO(petDTO);
                        ownerService.saveOwner(ownerDTO);
                        System.out.println("Owner has been saved successfully.");
                        break;
                    case 2:
                        int ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
                        ownerDTO = ownerService.findOwner(ownerId);
                        System.out.println("Owner has been fetched successfully.");
                        System.out.println(ownerDTO);
                        break;
                    case 3:
                        ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
                        String petName = InputUtil.acceptPetDetailsToUpdate(scanner);
                        ownerService.updatePetDetails(ownerId, petName);
                        System.out.println("Pet details of owner have been updated successfully.");
                        break;
                    case 4:
                        ownerId = InputUtil.acceptOwnerIdToOperate(scanner);
                        ownerService.deleteOwner(ownerId);
                        System.out.println("Owner has been deleted successfully.");
                        break;
                    case 5:
                        List<OwnerDTO> ownerDTOList = ownerService.findAllOwners();
                        System.out.println(String.format("There are %s owners.", ownerDTOList.size()));
                        ownerDTOList.forEach(System.out::println);
                    case 6:
                        int petId = InputUtil.acceptPetIdToOperate(scanner);
                        petDTO = petService.findPet(petId);
                        System.out.println("Pet has been fetched successfully.");
                        System.out.println(petDTO);
                        break;
                    default:
                        System.out.println("Invalid option entered.");
                }
            } while (InputUtil.wantToContinue(scanner));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
