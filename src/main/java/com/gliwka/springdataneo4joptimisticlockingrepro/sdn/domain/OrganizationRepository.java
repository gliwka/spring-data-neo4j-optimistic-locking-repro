package com.gliwka.springdataneo4joptimisticlockingrepro.sdn.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Long> {
    
    
}
