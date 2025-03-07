package br.com.colossal.holiday.entity;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.model.naming.NamingStrategies;

import java.time.LocalDate;

@MappedEntity(value = "tb_territory", namingStrategy = NamingStrategies.Raw.class)
public record Territory(
    @Id
    Long id,
    String name,
    LocalDate createdAt,
    LocalDate updatedAt
) {
    public Territory withUpdatedAt(LocalDate updatedAt) {
        return new Territory(id, name, createdAt, updatedAt);
    }
}