package org.librehealth.common.fhirpatientjsonfilter.controller;

import org.librehealth.common.fhirpatientjsonfilter.model.Patient;
import org.librehealth.common.fhirpatientjsonfilter.service.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MainController {


    @Autowired
    PatientRepository patientRepo;

    @GetMapping("/patients")
    public List<Patient> patient(@RequestParam(value="gender", required=false) String gender,
                                 @RequestParam(value="encounter", required = false) String encounter,
                                 @RequestParam(value="observation", required = false) String observation){

        return patientRepo.findPatient(gender, encounter, observation);

    }
}
