package org.librehealth.common.fhirpatientjsonfilter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Identifier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String use;

    private String system;

    private String uri;

    private String value;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Identifier() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
