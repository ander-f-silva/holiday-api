package br.com.colossal.holiday.service;

import br.com.colossal.holiday.repository.HolidayRepository;
import io.micronaut.cache.annotation.Cacheable;
import jakarta.inject.Singleton;

import java.util.Optional;

@Singleton
public class FindHoliday {
    private final HolidayRepository holidayRepository;

    public FindHoliday(HolidayRepository holidayRepository) {
        this.holidayRepository = holidayRepository;
    }

    @Cacheable("holidayName")
    public Optional<String> findHolidayName(String textTerritoryId, int dayOfMonth, int monthValue, int year) {
        Optional<String> holidayName = holidayRepository.findHolidayNameByDate(dayOfMonth, monthValue, year);

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