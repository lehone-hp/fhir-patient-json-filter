package org.librehealth.common.fhirpatientjsonfilter.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.librehealth.common.fhirpatientjsonfilter.model.Encounter;
import org.librehealth.common.fhirpatientjsonfilter.model.Observation;
import org.librehealth.common.fhirpatientjsonfilter.model.Patient;

import java.io.IOException;

/**
 * Get Json string representation of Resources by id
 */
public class ResourceService {

    private final static String baseUrl = "http://hapi.fhir.org/baseDstu3";

    public static Patient getPatientById(String id) throws IOException {
        String json = HttpClientService.getResource(baseUrl+"/Patient/"+id);
        return new ObjectMapper().readValue(json, Patient.class);
    }

    public static Encounter getEncounterById(String id) throws IOException {
        String json = HttpClientService.getResource(baseUrl+"/Encounter/"+id);
        return new ObjectMapper().readValue(json, Encounter.class);
    }

    public static Observation getObservationById(String id)  throws IOException {
        String json = HttpClientService.getResource(baseUrl+"/Observation/"+id);
        return new ObjectMapper().readValue(json, Observation.class);
    }

}
