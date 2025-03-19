package br.com.colossal.holiday.controller;

import br.com.colossal.holiday.dto.HolidayResponse;
import br.com.colossal.holiday.repository.HolidayRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Optional;

@Tag(name = "Holiday Controller", description = "Controller for managing holidays")
@Controller("/feriados")
@Secured("isAuthenticated()")
public class HolidayController {

    private static final Logger LOG = LoggerFactory.getLogger(HolidayController.class);
    private final HolidayRepository holidayRepository;

    public HolidayController(HolidayRepository holidayRepository) {
        this.holidayRepository = holidayRepository;
    }

    @Operation(summary = "Get holiday by ID and date", description = "Returns a holiday based on the provided ID and date")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Holiday found"),
            @ApiResponse(responseCode = "404", description = "Holiday not found")
    })
    @Get("/{territoryId}/{date}")
    public HttpResponse<HolidayResponse> getHoliday(
            @Parameter(description = "ID of the holiday") Long territoryId,
            @Parameter(description = "Date of the holiday in YYYY-MM-DD format") String date) {
        LOG.info("Fetching holiday with ID: {} and date: {}", territoryId, date);

        try {
            LocalDate localDate = LocalDate.parse(date);
            Optional<String> holidayResponse = holidayRepository.findHolidayNameByTerritoryIdPrefixAndDate(
                    String.valueOf(territoryId), localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear());

            return holidayResponse.map(name -> HttpResponse.ok(new HolidayResponse(name)))
                    .orElseGet(HttpResponse::notFound);
        } catch (DateTimeParseException e) {
            LOG.error("Invalid date format: {}", date, e);
            return HttpResponse.badRequest();
        }
    }
}