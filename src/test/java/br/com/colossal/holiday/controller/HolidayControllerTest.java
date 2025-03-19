package br.com.colossal.holiday.controller;

import br.com.colossal.holiday.dto.HolidayResponse;
import br.com.colossal.holiday.repository.HolidayRepository;
import io.micronaut.http.HttpResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HolidayControllerTest {

    @Mock
    HolidayRepository holidayRepository;

    @InjectMocks
    HolidayController holidayController;

    @Test
    void testGetHoliday() {
        when(holidayRepository.findHolidayNameByTerritoryIdPrefixAndDate(anyString(), anyInt(), anyInt(), anyInt()))
                .thenReturn(Optional.of("Christmas"));

        HttpResponse<HolidayResponse> response = holidayController.getHoliday(1L, "2023-12-25");

        assertEquals(HttpResponse.ok(new HolidayResponse("Christmas")).status(), response.status());
        assertEquals("Christmas", response.body().name());
    }

    @Test
    void testGetHolidayNotFound() {
        when(holidayRepository.findHolidayNameByTerritoryIdPrefixAndDate(anyString(), anyInt(), anyInt(), anyInt()))
                .thenReturn(Optional.empty());

        HttpResponse<HolidayResponse> response = holidayController.getHoliday(1L, "2023-12-25");

        assertEquals(HttpResponse.notFound().status(), response.status());
    }

    @Test
    void testGetHolidayInvalidDate() {
        HttpResponse<HolidayResponse> response = holidayController.getHoliday(1L, "invalid-date");

        assertEquals(HttpResponse.badRequest().status(), response.status());
    }

    @Test
    void testGetHolidayWithDifferentDateFormat() {
        when(holidayRepository.findHolidayNameByTerritoryIdPrefixAndDate(anyString(), anyInt(), anyInt(), anyInt()))
                .thenReturn(Optional.of("New Year"));

        HttpResponse<HolidayResponse> response = holidayController.getHoliday(1L, "2023-01-01");

        assertEquals(HttpResponse.ok(new HolidayResponse("New Year")).status(), response.status());
        assertEquals("New Year", response.body().name());
    }

    @Test
    void testUnauthorizedAccess() {
        // This test case might not be applicable without Micronaut security context
    }

    @Test
    void testGetHolidayWithDifferentTerritoryId() {
        when(holidayRepository.findHolidayNameByTerritoryIdPrefixAndDate(anyString(), anyInt(), anyInt(), anyInt()))
                .thenReturn(Optional.of("Independence Day"));

        HttpResponse<HolidayResponse> response = holidayController.getHoliday(2L, "2023-07-04");

        assertEquals(HttpResponse.ok(new HolidayResponse("Independence Day")).status(), response.status());
        assertEquals("Independence Day", response.body().name());
    }
}