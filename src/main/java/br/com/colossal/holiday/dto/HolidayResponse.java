package br.com.colossal.holiday.dto;

import io.micronaut.serde.annotation.SerdeImport;

@SerdeImport
public record HolidayResponse(String name) {
}