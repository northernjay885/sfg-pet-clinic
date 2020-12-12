package org.northernjay.sfgpetclinic.repositories;

import org.northernjay.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String LastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
