package org.librehealth.common.fhirpatientjsonfilter.component;

import org.librehealth.common.fhirpatientjsonfilter.model.Encounter;
import org.librehealth.common.fhirpatientjsonfilter.model.HumanName;
import org.librehealth.common.fhirpatientjsonfilter.model.Observation;
import org.librehealth.common.fhirpatientjsonfilter.model.Patient;
import org.librehealth.common.fhirpatientjsonfilter.service.PatientRepository;
import org.librehealth.common.fhirpatientjsonfilter.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class Setup implements CommandLineRunner {

    @Autowired
    PatientRepository patientRepo;

    @Transactional
    @Override
    public void run(String... strings) {

        String[] patientIds = {"14842", "patient-43", "cf-1517368349477", "275145", "cc-pat-david"};
        String[] encounterIds = {"encounter-654", "encounter-645", "encounter-643", "encounter-568", "encounter-68"};
        String[][] observations = {
                {"330384", "306458", "14859", "270910", "200767" },
                {"335083", "335084", "335081", "335082", "335087"},
                {"cf-1517368713638", "cf-1517369503777", "198751", "198741"},
                {"198708", "198738", "198743", "198739", "198747"},
                {"201135", "198729", "198723", "198724"}};
        // Invoke the client
        for (int i=0; i<patientIds.length; i++) {

            try{

                Patient patient = ResourceService.getPatientById(patientIds[i]);
                for(HumanName name : patient.getName()){
                    name.setPatient(patient);
                }
                Encounter encounter = ResourceService.getEncounterById(encounterIds[i]);
                encounter.setPatient(patient);

                for(int j=0; j<observations[i].length; j++) {
                    Observation ob = ResourceService.getObservationById(observations[i][j]);
                    ob.setEncounter(encounter);
                    encounter.addObservation(ob);
                }

                patient.addEncounter(encounter);
                patientRepo.save(patient);
                System.out.println("Patient "+i+" saved");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        for (Patient p : patientRepo.findAll()) {

            try {

                String given = "";
                try {
                    given = p.getName().get(0).getGiven().get(0);
                } catch (Exception e ) {
                    System.err.println(e.getLocalizedMessage());
                }

                System.out.println("Patient+: "+p.getId()+"\t"
                        +p.getName().get(0).getFamily()+"\t"
                        +(given.isEmpty() ? "" : given)+"\t"
                        +p.getBirthDate());
                for (Encounter e : p.getEncounters()) {
                    System.out.println("\tEncounter: "+e.getId()+"\t"+e.getStatus());

                    for (Observation o : e.getObservations()){
                        System.out.println("\t\tObs: "+o.getId()+"\t"+o.getStatus());
                    }
                }

                System.out.println("\n");
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }

    }
}
