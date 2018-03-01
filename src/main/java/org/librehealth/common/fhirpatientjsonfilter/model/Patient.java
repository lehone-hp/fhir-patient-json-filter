package org.librehealth.common.fhirpatientjsonfilter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.*;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Patient {

    @Id
    private String id;

    private boolean active = true;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("birthDate")
    private Date birthDate;

    private Boolean deceasedBoolean = false;

//    @JsonProperty("identifier")
//    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
//    private List<Identifier> identifier = new ArrayList<>();

    @JsonProperty("name")
    @JsonIgnoreProperties("patient")
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<HumanName> name = new ArrayList<>();

    @JsonIgnoreProperties("patient")
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Encounter> encounters = new ArrayList<>();

    public Patient() {
    }


    public String getId() {
        return id;
    }

    public List<Encounter> getEncounters() {
        return encounters;
    }

    public void setEncounters(List<Encounter> encounters) {
        this.encounters = encounters;
    }

    public void addEncounter(Encounter encounter) {
        encounters.add(encounter);
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getDeceasedBoolean() {
        return deceasedBoolean;
    }

    public void setDeceasedBoolean(Boolean deceasedBoolean) {
        this.deceasedBoolean = deceasedBoolean;
    }
/*
    public List<Identifier> getIdentifier() {
        return identifier;
    }

    public void setIdentifier(List<Identifier> identifier) {
        this.identifier = identifier;
    }
*/
    public List<HumanName> getName() {
        return name;
    }

    public void setName(List<HumanName> name) {
        this.name = name;
    }
}
