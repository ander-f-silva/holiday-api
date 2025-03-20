package br.com.colossal.holiday.service;

import br.com.colossal.holiday.repository.HolidayRepository;
import io.micronaut.cache.annotation.Cacheable;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Optional;

@Singleton
public class FindHoliday {
    private static final Logger LOG = LoggerFactory.getLogger(FindHoliday.class);

    private final HolidayRepository holidayRepository;

    public FindHoliday(HolidayRepository holidayRepository) {
        this.holidayRepository = holidayRepository;
    }

    @Cacheable("holidays")
    public Optional<String> getHolidayName(Integer territoryId, LocalDate date) {
        Optional<String> holidayName = findHolidayNational(date);

        if (holidayName.isEmpty()) {
            var textTerritoryId = territoryId.toString();

            if (isCodeState(textTerritoryId))
                holidayName = findHolidayState(textTerritoryId, date);
            else
                holidayName = findHolidayCity(territoryId, date);
        }

        return holidayName;
    }

    private Optional<String> findHolidayNational(LocalDate date) {
        LOG.info("Fetching holiday national with date: {}", date);

        int dayOfMonth = date.getDayOfMonth();
        int monthValue = date.getMonthValue();

        return holidayRepository.findHolidayNameByDayAndMoth(dayOfMonth, monthValue);
    }

    private Optional<String> findHolidayState(String textTerritoryId, LocalDate date) {
        LOG.info("Fetching state holiday with ID: {} and date: {}", textTerritoryId, date);

        int dayOfMonth = date.getDayOfMonth();
        int monthValue = date.getMonthValue();
        int year = date.getYear();

        return holidayRepository.findHolidayNameByTerritoryIdPrefixAndDate(textTerritoryId, dayOfMonth, monthValue, year);
    }

    public Optional<String> findHolidayCity(Integer territoryId, LocalDate date) {
        LOG.info("Fetching city holiday with ID: {} and date: {}", territoryId, date);

        int dayOfMonth = date.getDayOfMonth();
        int monthValue = date.getMonthValue();
        int year = date.getYear();

        return holidayRepository.findHolidayNameByTerritoryIdAndDate(territoryId, dayOfMonth, monthValue, year);
    }

    private boolean isCodeState(String textTerritoryId) {
        return textTerritoryId.length() < 3;
    }
}