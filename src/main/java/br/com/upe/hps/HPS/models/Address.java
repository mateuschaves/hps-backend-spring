package br.com.upe.hps.HPS.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.NONE)
    private Long id;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String uf;

    @Column(nullable = false)
    private String neighborhood;

    @Column(nullable = false)
    private String referencePoint;

    @Column(nullable = false)
    private String number;

    @OneToOne(mappedBy = "address")
    private Building building;

    public Address(Long id, String cep, String street, String city, String uf, String neighborhood, String referencePoint, String number) {
        this.id = id;
        this.cep = cep;
        this.street = street;
        this.city = city;
        this.uf = uf;
        this.neighborhood = neighborhood;
        this.referencePoint = referencePoint;
        this.number = number;
    }

    public Address(Long id, String cep, String street, String city, String uf, String neighborhood, String referencePoint, Building building) {
        this.id = id;
        this.cep = cep;
        this.street = street;
        this.city = city;
        this.uf = uf;
        this.neighborhood = neighborhood;
        this.referencePoint = referencePoint;
        this.building = building;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getReferencePoint() {
        return referencePoint;
    }

    public void setReferencePoint(String referencePoint) {
        this.referencePoint = referencePoint;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
