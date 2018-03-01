package org.librehealth.common.fhirpatientjsonfilter.service;

import org.librehealth.common.fhirpatientjsonfilter.model.Observation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObservationRepository extends JpaRepository<Observation, String> {
}
