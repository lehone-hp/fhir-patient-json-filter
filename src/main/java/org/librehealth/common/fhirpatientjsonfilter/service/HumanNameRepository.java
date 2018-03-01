package org.librehealth.common.fhirpatientjsonfilter.service;

import org.librehealth.common.fhirpatientjsonfilter.model.HumanName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumanNameRepository extends JpaRepository<HumanName, Long> {
}
