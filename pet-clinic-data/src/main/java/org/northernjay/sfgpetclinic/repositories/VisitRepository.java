package org.northernjay.sfgpetclinic.repositories;

import org.northernjay.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
