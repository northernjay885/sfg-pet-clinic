package org.northernjay.sfgpetclinic.services;

import org.northernjay.sfgpetclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastname(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);

}
