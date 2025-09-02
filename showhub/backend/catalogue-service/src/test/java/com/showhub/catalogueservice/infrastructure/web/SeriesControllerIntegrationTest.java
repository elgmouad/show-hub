package com.showhub.catalogueservice.infrastructure.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.showhub.catalogueservice.domain.Series;
import com.showhub.catalogueservice.infrastructure.persistence.SeriesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = { "spring.cloud.config.enabled=false", "spring.cloud.discovery.enabled=false" })
public class SeriesControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SeriesRepository seriesRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        seriesRepository.deleteAll();
    }

    @Test
    void getAllSeries_shouldReturnSeriesList() throws Exception {
        // Arrange
        List<Series> seriesList = new ArrayList<>();
        seriesList.add(new Series(null, "The Wire", "The drug trade in Baltimore through the eyes of dealers and law enforcement."));
        seriesList.add(new Series(null, "Sopranos", "An Italian-American mobster in New Jersey struggles with family and his criminal life."));
        seriesRepository.saveAll(seriesList);

        // Act
        MvcResult mvcResult = mockMvc.perform(get("/api/v1/series"))
                .andExpect(status().isOk())
                .andReturn();

        // Assert
        String responseBody = mvcResult.getResponse().getContentAsString();
        Series[] returnedSeries = objectMapper.readValue(responseBody, Series[].class);

        assertThat(returnedSeries).hasSize(2);
        assertThat(returnedSeries[0].getTitle()).isEqualTo("The Wire");
        assertThat(returnedSeries[1].getTitle()).isEqualTo("Sopranos");
    }
}
