package org.nsi.alpha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class NsiAlphaApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(NsiAlphaApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(NsiAlphaApplication.class, args);
	}
}