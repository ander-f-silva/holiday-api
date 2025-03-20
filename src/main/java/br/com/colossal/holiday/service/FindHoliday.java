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

    @Cacheable("holiday-name")
    public Optional<String> findHolidayName(Integer territoryId, LocalDate date) {
        LOG.info("Fetching holiday with ID: {} and date: {}", territoryId, date);

        var textTerritoryId = territoryId.toString();
        int dayOfMonth = date.getDayOfMonth();
        int monthValue = date.getMonthValue();
        int year = date.getYear();

        Optional<String> holidayName = holidayRepository.findHolidayNameByDayAndMoth(dayOfMonth, monthValue);

        if (holidayName.isEmpty()) {
            if (textTerritoryId.length() < 3) {
                holidayName = holidayRepository.findHolidayNameByTerritoryIdPrefixAndDate(textTerritoryId, dayOfMonth, monthValue, year);
            } else {
                holidayName = holidayRepository.findHolidayNameByTerritoryIdAndDate(textTerritoryId, dayOfMonth, monthValue, year);
            }
        }

        return holidayName;
    }
}