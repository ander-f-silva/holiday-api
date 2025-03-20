package br.com.colossal.holiday.repository;

import br.com.colossal.holiday.entity.Holiday;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.repository.CrudRepository;

import java.util.Optional;

@JdbcRepository(dialect = io.micronaut.data.model.query.builder.sql.Dialect.POSTGRES)
public interface HolidayRepository extends CrudRepository<Holiday, Long> {

    @Query("SELECT h.name FROM tb_holiday h " +
            "JOIN tb_holiday_territory ht ON h.id = ht.holiday_id " +
            "JOIN tb_territory t ON ht.territory_id = t.id " +
            "WHERE SUBSTRING(t.id::text, 1, 2) = :textTerritoryIdPrefix " +
            "AND h.day = :day " +
            "AND h.month = :month " +
            "AND h.year = :year " +
            "LIMIT 1")
    Optional<String> findHolidayNameByTerritoryIdPrefixAndDate(String textTerritoryIdPrefix, int day, int month, int year);

    @Query("SELECT h.name FROM tb_holiday h " +
            "JOIN tb_holiday_territory ht ON h.id = ht.holiday_id " +
            "JOIN tb_territory t ON ht.territory_id = t.id " +
            "WHERE t.id = :textTerritoryId " +
            "AND h.day = :day " +
            "AND h.month = :month " +
            "AND h.year = :year " +
            "LIMIT 1")
    Optional<String> findHolidayNameByTerritoryIdAndDate(String textTerritoryId, int dayOfMonth, int monthValue, int year);

    @Query("SELECT h.name FROM tb_holiday h " +
            "WHERE h.day = :day " +
            "AND h.month = :month " +
            "AND h.year = :year")
    Optional<String> findHolidayNameByDate(int dayOfMonth, int monthValue, int year);
}