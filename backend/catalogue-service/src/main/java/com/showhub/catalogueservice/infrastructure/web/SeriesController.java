package com.showhub.catalogueservice.infrastructure.web;

import com.showhub.catalogueservice.domain.Series;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/series")
public class SeriesController {

    @GetMapping
    public List<Series> getAllSeries() {
        // Return a hardcoded list of series for now
        List<Series> seriesList = new ArrayList<>();
        seriesList.add(new Series(1L, "Breaking Bad", "A high school chemistry teacher turned methamphetamine kingpin."));
        seriesList.add(new Series(2L, "Game of Thrones", "Nine noble families fight for control over the lands of Westeros."));
        return seriesList;
    }
}
