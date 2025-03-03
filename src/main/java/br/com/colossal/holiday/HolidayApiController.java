package br.com.colossal.holiday;

import io.micronaut.http.annotation.*;

@Controller("/holiday-api")
public class HolidayApiController {

    @Get(uri="/", produces="text/plain")
    public String index() {
        return "Example Response";
    }
}