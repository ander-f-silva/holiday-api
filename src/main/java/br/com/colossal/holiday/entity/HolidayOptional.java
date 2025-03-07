package br.com.colossal.holiday.entity;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;
import io.micronaut.data.annotation.Relation;
import io.micronaut.data.model.naming.NamingStrategies;

import java.time.LocalDate;

@MappedEntity(value = "tb_holiday_optional", namingStrategy = NamingStrategies.Raw.class)
public record HolidayOptional(
        @Id
        @GeneratedValue(GeneratedValue.Type.IDENTITY)
        Long id,
        String description,
        LocalDate createdAt,
        LocalDate updatedAt,
        @Relation(value = Relation.Kind.MANY_TO_ONE)
        @MappedProperty("holiday_id")
        Holiday holiday
) {
    public HolidayOptional withUpdatedAt(LocalDate updatedAt) {
        return new HolidayOptional(id, description, createdAt, updatedAt, holiday);
    }
}