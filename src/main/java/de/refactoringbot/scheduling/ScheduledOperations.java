package de.refactoringbot.scheduling;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * This class performs scheduled operations.
 * 
 * @author Stefan Basaric
 *
 */
@Component
public class ScheduledOperations {

	@Value("${server.port}")
	Integer port;

	private static final Logger logger = LoggerFactory.getLogger(ScheduledOperations.class);
	
	/**
	 * This method opens the Swagger-UI in the browser on startup of the
	 * application.
	 */
	@PostConstruct
	public void startSwaggerUI() {
		// Start runtime
		Runtime runtime = Runtime.getRuntime();
		// Create URL
		String url = "http://localhost:" + port + "/swagger-ui.html#";
		// Check OS-System
		String os = System.getProperty("os.name").toLowerCase();
		try {
			// Windows
			if (os.contains("win")) {
				runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
			}
			// MacOS
			if (os.contains("mac")) {
				runtime.exec("open " + url);
			}
			// Linux
			if (os.contains("nix") || os.contains("nux")) {
				runtime.exec("xdg-open " + url);
			}
		} catch (IOException e) {
			logger.error("Could not start Swagger-UI in the browser!");
		}
	}

}
