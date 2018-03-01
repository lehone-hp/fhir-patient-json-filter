package org.librehealth.common.fhirpatientjsonfilter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Observation {

    @Id
    private String id;

    @JsonProperty("status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "encounter_id")
    private Encounter encounter;

    public String getId() {
        return id;
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

    public Encounter getEncounter() {
        return this.encounter;
    }

    public void setEncounter(Encounter encounter) {
        this.encounter = encounter;
    }

}