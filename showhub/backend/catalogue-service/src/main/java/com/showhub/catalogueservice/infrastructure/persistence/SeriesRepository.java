package com.showhub.catalogueservice.infrastructure.persistence;

import com.showhub.catalogueservice.domain.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesRepository extends JpaRepository<Series, Long> {
}
