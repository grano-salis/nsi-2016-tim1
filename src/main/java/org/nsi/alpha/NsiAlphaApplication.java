package org.nsi.alpha;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class NsiAlphaApplication {

	@RequestMapping("/")
	String home() {
		return "Hello world!";
	}

	public static void main(String[] args) {
		new SpringApplicationBuilder(NsiAlphaApplication.class)
				.run(args);
	}
}
