package com.showhub.catalogueservice.application.usecases;

import com.showhub.catalogueservice.domain.Series;
import com.showhub.catalogueservice.infrastructure.persistence.SeriesRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SeriesService {

    private final SeriesRepository seriesRepository;

    public SeriesService(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    public List<Series> findAll() {
        return seriesRepository.findAll();
    }
}
