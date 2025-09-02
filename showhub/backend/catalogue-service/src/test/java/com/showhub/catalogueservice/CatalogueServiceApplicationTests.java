package com.showhub.catalogueservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = { "spring.cloud.config.enabled=false", "spring.cloud.discovery.enabled=false" })
class CatalogueServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
