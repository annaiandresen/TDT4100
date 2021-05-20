package patterns.delegation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class FilteringLogger implements ILogger {
	private Collection<String> severities;
	private ILogger logger;

	/**
	 * Initializes the object which delegates log() to a different logger object
	 * @param logger The delegated logger
	 * @param severities The level of severity which is used to filter
	 */
	public FilteringLogger(ILogger logger, String ... severities) {
		this.severities = new ArrayList<>(Arrays.asList(severities));
		this.logger = logger;
	}

	@Override
	public void log(String severity, String message, Exception exception) throws Exception {
		if (severities.contains(severity)) logger.log(severity, message, exception);
		
	}
	
	public boolean isLogging(String severity) {
		return severities.contains(severity);
	}
	
	public void setIsLogging(String severity, boolean value) {
		if (severities.contains(severity)) {
			if (!value) {
				severities.remove(severity);
			}
		} else {
			if (value) {
				severities.add(severity);
			}
		}
	}

}
