package br.com.upe.hps.HPS.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CreateAddressDto {
    @NotEmpty
    private String description;
    @NotEmpty
    private String cep;
    @NotEmpty
    private String street;
    @NotEmpty
    private String city;
    @NotEmpty
    private String uf;
    @NotEmpty
    private String neighborhood;
    @NotEmpty
    private String number;
    @NotEmpty
    private String referencePoint;
}
