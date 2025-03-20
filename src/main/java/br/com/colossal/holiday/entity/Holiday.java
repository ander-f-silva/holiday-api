package br.com.colossal.holiday.entity;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.model.naming.NamingStrategies;

import java.time.LocalDate;

@MappedEntity(value = "tb_holiday", namingStrategy = NamingStrategies.Raw.class)
public record Holiday(
        @Id
        @GeneratedValue(GeneratedValue.Type.IDENTITY)
        Long id,
        int day,
        int month,
        int year,
        String name,
        LocalDate createdAt,
        LocalDate updatedAt
) {
}