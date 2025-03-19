package br.com.colossal.holiday.repository;

import br.com.colossal.holiday.entity.Holiday;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.GenericRepository;

import java.util.Optional;

@Repository
public interface HolidayRepository extends GenericRepository<Holiday, Long> {

    @Query("SELECT h.name FROM Holiday h WHERE h.territoryId = :territoryId AND h.day = :day AND h.month = :month AND h.year = :year")
    Optional<String> findHolidayNameByTerritoryIdAndDate(Long territoryId, int day, int month, int year);
}