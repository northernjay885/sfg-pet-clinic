package org.northernjay.sfgpetclinic.repositories;

import org.northernjay.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
