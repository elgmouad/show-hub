package com.showhub.configservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = { "spring.cloud.discovery.enabled=false" })
class ConfigServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
