package br.com.upe.hps.HPS.dtos;

import br.com.upe.hps.HPS.models.Building;

import java.util.List;
import java.util.stream.Collectors;

public class ListBuildingDto {
    private Long id;
    private String building;
    private String description;
    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String uf;
    private Float price;

    public ListBuildingDto(Building building) {
        this.id = building.getId();
        this.building = building.getBuilding();
        this.description = building.getDescription();
        this.street = building.getStreet();
        this.number = building.getNumber();
        this.neighborhood = building.getNeighborhood();
        this.city = building.getCity();
        this.uf = building.getUf();
        this.price = building.getPrice();
    }

    public static List<ListBuildingDto> toDto(List<Building> buildings) {
        return buildings.stream().map(ListBuildingDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
