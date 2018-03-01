package org.librehealth.common.fhirpatientjsonfilter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Encounter {

    @Id
    private String id;

    @JsonProperty("status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @JsonIgnoreProperties("encounter")
    @OneToMany(mappedBy = "encounter", cascade = CascadeType.ALL)
    private List<Observation> observations = new ArrayList<>();

    public Encounter() {

    }

   public String getId() {
        return id;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Observation> getObservations() {
        return observations;
    }

    public void setObservations(List<Observation> observations) {
        this.observations = observations;
    }

    public void addObservation(Observation observation) {
        this.observations.add(observation);
    }
}

