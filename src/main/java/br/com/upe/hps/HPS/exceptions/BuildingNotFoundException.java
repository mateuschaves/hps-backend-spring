package br.com.upe.hps.HPS.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "Apartamento não encontrado")
public class BuildingNotFoundException extends RuntimeException {
}
