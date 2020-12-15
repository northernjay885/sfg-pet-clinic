package org.northernjay.sfgpetclinic.controllers;


import org.northernjay.sfgpetclinic.model.Owner;
import org.northernjay.sfgpetclinic.model.Pet;
import org.northernjay.sfgpetclinic.model.Visit;
import org.northernjay.sfgpetclinic.services.PetService;
import org.northernjay.sfgpetclinic.services.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.time.LocalDate;

@Controller
@RequestMapping("owners/{ownerId}/pets/{petId}")
public class VisitController {

    private static final String VIEWS_VISITS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdateVisitForm";

    private final PetService petService;
    private final VisitService visitService;

    public VisitController(PetService petService, VisitService visitService) {
        this.petService = petService;
        this.visitService = visitService;
    }

    @ModelAttribute("pet")
    public Pet findPet(@PathVariable Long petId) {
        return petService.findById(petId);
    }

    @InitBinder
    public void initPetBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");

        dataBinder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                setValue(LocalDate.parse(text));
            }
        });
    }

    @GetMapping("/visits/new")
    public String initCreationForm(Pet pet, Model model) {
        Visit visit = new Visit();
        visit.setPet(pet);
        pet.getVisits().add(visit);
        model.addAttribute("visit", visit);
        return VIEWS_VISITS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/visits/new")
    public String processVisitForm(@Valid Visit visit, BindingResult result, Pet pet) {
        if (result.hasErrors()) {
            return VIEWS_VISITS_CREATE_OR_UPDATE_FORM;
        } else {
            visit.setPet(pet);
            pet.getVisits().add(visit);
            visitService.save(visit);
            return "redirect:/owners/{ownerId}";
        }
    }
}
