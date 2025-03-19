package br.com.colossal.holiday.repository;

import br.com.colossal.holiday.dto.HolidayResponse;
import br.com.colossal.holiday.entity.HolidayOptional;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.GenericRepository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface HolidayOptionalRepository extends GenericRepository<HolidayOptional, Long> {

    @Query("SELECT new br.com.colossal.holiday.dto.HolidayResponse(h.description) " +
           "FROM HolidayOptional h WHERE h.holiday.id = :holidayId AND h.createdAt = :createdAt")
    Optional<HolidayResponse> findHolidayResponseByHolidayIdAndCreatedAt(Long holidayId, LocalDate createdAt);
}