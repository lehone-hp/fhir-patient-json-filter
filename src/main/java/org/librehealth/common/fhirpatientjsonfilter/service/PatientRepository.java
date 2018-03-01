package org.librehealth.common.fhirpatientjsonfilter.service;

import org.librehealth.common.fhirpatientjsonfilter.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {
}
