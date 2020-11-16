package org.northernjay.sfgpetclinic.services;

import org.northernjay.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastname(String lastName);

}
