package org.northernjay.sfgpetclinic.repositories;

import org.northernjay.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
