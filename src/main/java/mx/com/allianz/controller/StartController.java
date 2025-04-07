package mx.com.allianz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartController {
	private static final Logger LOGGER = LoggerFactory.getLogger(StartController.class);

	@GetMapping("/Hola")
	public String start() {
		LOGGER.info("Hola MUndos!");
		return "Starting archetype...";
	}

}
