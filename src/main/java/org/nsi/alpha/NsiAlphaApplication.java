package org.nsi.alpha;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class NsiAlphaApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(NsiAlphaApplication.class);

	@RequestMapping("/home")
	String home() {
		return "home";
	}

	public static void main(String[] args) {
		new SpringApplicationBuilder(NsiAlphaApplication.class)
				.run(args);
		LOGGER.info("ULOGUJ NESTO PAMETNO TU MOLIM TE");
		LOGGER.warn("Hvala najljepsa");
	}
}
