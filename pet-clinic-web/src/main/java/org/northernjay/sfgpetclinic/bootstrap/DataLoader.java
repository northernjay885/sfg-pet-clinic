package org.northernjay.sfgpetclinic.bootstrap;

import org.northernjay.sfgpetclinic.model.*;
import org.northernjay.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    final private OwnerService ownerService;
    final private VetService vetService;
    final private PetTypeService petTypeService;
    final private SpecialityService specialityService;
    final private VisitService visitService;
    final private PetService petService;

    public DataLoader(OwnerService ownerService,
                      VetService vetService,
                      PetTypeService petTypeService,
                      SpecialityService specialityService,
                      VisitService visitService,
                      PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
        this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if(count == 0) {
            loadData();
        }
    }

//    private void loadData() {
//        PetType dog = new PetType();
//        dog.setName("Dog");
//        PetType savedDogPetType = petTypeService.save(dog);
//
//        PetType cat = new PetType();
//        cat.setName("Cat");
//        PetType savedCatPetType = petTypeService.save(cat);
//
//        Speciality radiology = new Speciality();
//        radiology.setDescription("Radiology");
//        Speciality savedRadiology = specialityService.save(radiology);
//
//        Speciality surgery = new Speciality();
//        surgery.setDescription("Surgery");
//        Speciality savedSurgery = specialityService.save(surgery);
//
//        Speciality dentistry = new Speciality();
//        dentistry.setDescription("dentistry");
//        Speciality savedDentistry = specialityService.save(dentistry);
//
//        Owner owner1 = new Owner();
//        owner1.setFirstName("Michael");
//        owner1.setLastName("Weston");
//        owner1.setAddress("123 Brickerel");
//        owner1.setCity("Miami");
//        owner1.setTelephone("1231231234");
//
//        Pet mikesPet = new Pet();
//        mikesPet.setPetType(savedDogPetType);
//        mikesPet.setOwner(owner1);
//        mikesPet.setBirthDate(LocalDate.now());
//        mikesPet.setName("Rosco");
//        owner1.getPets().add(mikesPet);
//
//        ownerService.save(owner1);
//
//        Owner owner2 = new Owner();
//        owner2.setFirstName("Fiona");
//        owner2.setLastName("Glenanne");
//        owner2.setAddress("123 Brickerel");
//        owner2.setCity("Miami");
//        owner2.setTelephone("1231231234");
//
//        Pet fionasCat = new Pet();
//        fionasCat.setName("Just Cat");
//        fionasCat.setOwner(owner2);
//        fionasCat.setBirthDate(LocalDate.now());
//        fionasCat.setPetType(savedCatPetType);
//        owner2.getPets().add(fionasCat);
//
//        ownerService.save(owner2);
//
//        Visit catVisit = new Visit();
//        catVisit.setPet(fionasCat);
//        catVisit.setDate(LocalDate.now());
//        catVisit.setDescription("Sneezy Kitty");
//
//        visitService.save(catVisit);
//
//        System.out.println("Loaded Owners....");
//
//        Vet vet1 = new Vet();
//        vet1.setFirstName("Sam");
//        vet1.setLastName("Axe");
//        vet1.getSpecialities().add(savedRadiology);
//
//        vetService.save(vet1);
//
//        Vet vet2 = new Vet();
//        vet2.setFirstName("Jessie");
//        vet2.setLastName("Porter");
//        vet2.getSpecialities().add(savedSurgery);
//
//        vetService.save(vet2);
//
//        System.out.println("Loaded Vets....");
//    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        PetType hog = new PetType();
        hog.setName("Hog");
        PetType savedHogType = petTypeService.save(hog);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Micheal");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("213142134");

        Pet michaelsPet = new Pet();
        michaelsPet.setName("Liky");
        michaelsPet.setPetType(savedDogType);
        michaelsPet.setOwner(owner1);
        michaelsPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(michaelsPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenine");
        owner2.setAddress("234 Brickerel");
        owner2.setCity("Berkley");
        owner2.setTelephone("21334134");

        Pet fionasCat = new Pet();
        fionasCat.setName("Reky");
        fionasCat.setPetType(savedCatType);
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(fionasCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");
        visitService.save(catVisit);

        Visit catVisit2 = new Visit();
        catVisit2.setPet(fionasCat);
        catVisit2.setDate(LocalDate.now());
        catVisit2.setDescription("KJLKJ");
        visitService.save(catVisit2);

        System.out.println("Loaded Owners.....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Regan");
        vet2.setLastName("Fox");
        vet1.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets.....");
    }
}
