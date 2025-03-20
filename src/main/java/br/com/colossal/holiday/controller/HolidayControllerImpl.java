package br.com.colossal.holiday.controller;

import br.com.colossal.holiday.controller.api.HolidayController;
import br.com.colossal.holiday.dto.HolidayResponse;
import br.com.colossal.holiday.service.FindHoliday;
import io.micronaut.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class HolidayControllerImpl implements HolidayController {
    private static final Logger LOG = LoggerFactory.getLogger(HolidayControllerImpl.class);
    private final FindHoliday findHoliday;

    public HolidayControllerImpl(FindHoliday findHoliday) {
        this.findHoliday = findHoliday;
    }

    @Override
    public HttpResponse<HolidayResponse> getHoliday(Integer territoryId, LocalDate date) {
        LOG.info("Fetching holiday with ID: {} and date: {}", territoryId, date);

        var textTerritoryId = territoryId.toString();
        int dayOfMonth = date.getDayOfMonth();
        int monthValue = date.getMonthValue();
        int year = date.getYear();

        var holidayName = findHoliday.findHolidayName(textTerritoryId, dayOfMonth, monthValue, year);

        return holidayName.map(name -> HttpResponse.ok(new HolidayResponse(name)))
                .orElseGet(HttpResponse::notFound);
    }
}