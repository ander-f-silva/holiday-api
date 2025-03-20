package br.com.colossal.holiday.entity;

import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.model.naming.NamingStrategies;

@MappedEntity(value = "tb_holiday_territory", namingStrategy = NamingStrategies.Raw.class)
public record HolidayTerritory(
        Long holidayId,
        Long territoryId
) {
}