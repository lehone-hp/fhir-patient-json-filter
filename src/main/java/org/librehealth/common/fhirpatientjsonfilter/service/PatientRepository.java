package org.librehealth.common.fhirpatientjsonfilter.service;

import org.librehealth.common.fhirpatientjsonfilter.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {

    /**
     * Search patient based on ...
     * @param gender of the patient
     * @param encounter status and
     * @param observation status
     * @return all patients from the search result
     */
    @Query("SELECT distinct p " +
            "from Patient p join p.encounters e join e.observations o " +
            "where p.gender = :gender and e.status = :encounter and o.status = :observation")
    List<Patient> findPatient(@Param("gender") String gender,
                                    @Param("encounter") String encounter,
                                    @Param("observation") String observation);
}
