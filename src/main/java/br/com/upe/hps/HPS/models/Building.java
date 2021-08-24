package br.com.upe.hps.HPS.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.NONE)
    private Long id;

    @Column(nullable = false)
    private String building;

    @Column(nullable = false)
    private String owner;

    @Column(nullable = false)
    private String contact;

    @Column(nullable = false)
    private String description;

    @OneToOne
    @JoinColumn
    private Address address;

    @Column(nullable = false)
    private Float price;

    public Building(String building, String owner, String contact, String description, Float price) {
        this.building = building;
        this.owner = owner;
        this.contact = contact;
        this.description = description;
        this.price = price;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
