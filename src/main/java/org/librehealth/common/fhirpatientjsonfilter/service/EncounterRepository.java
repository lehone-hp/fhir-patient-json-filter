package org.librehealth.common.fhirpatientjsonfilter.service;

import org.librehealth.common.fhirpatientjsonfilter.model.Encounter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncounterRepository extends JpaRepository<Encounter, String>{
}
