package br.com.colossal.holiday.controller;

import br.com.colossal.holiday.dto.HolidayResponse;
import br.com.colossal.holiday.service.FindHoliday;
import io.micronaut.core.convert.format.Format;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

@Controller("/feriados")
@Secured("isAuthenticated()")
@Tag(name = "Holiday Controller", description = "Controller for managing holidays")
public class HolidayController {
    private final FindHoliday findHoliday;

    public HolidayController(FindHoliday findHoliday) {
        this.findHoliday = findHoliday;
    }

    @Get("/{territoryId}/{date}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Holiday found"),
            @ApiResponse(responseCode = "404", description = "Holiday not found")
    })
    @Operation(summary = "Get holiday by ID and date", description = "Returns a holiday based on the provided ID and date")
    HttpResponse<HolidayResponse> getHoliday(
            @Parameter(description = "ID of the holiday")
            @Positive Integer territoryId,
            @Parameter(description = "Date of the holiday in YYYY-MM-DD format")
            @Format("yyyy-MM-dd") LocalDate date) {

        var holidayName = findHoliday.findHolidayName(territoryId, date);

        return holidayName.map(name -> HttpResponse.ok(new HolidayResponse(name)))
                .orElseGet(HttpResponse::notFound);
    }
}