package patterns.delegation;

public class DistributingLogger implements ILogger {
	private ILogger errorLogger;
	private ILogger warningLogger;
	private ILogger infoLogger;
	
	/**
	 * Used to distribute log messages to other loggers, based on their severity
	 * @param errorLogger
	 * @param warningLogger
	 * @param infoLogger
	 */
	public DistributingLogger(ILogger errorLogger, ILogger warningLogger, ILogger infoLogger) {
		this.errorLogger = errorLogger;
		this.warningLogger = warningLogger;
		this.infoLogger = infoLogger;
	}

	@Override
	public void log(String severity, String message, Exception exception) throws Exception {
		switch (severity) {
		case "error":
			if (errorLogger != null) errorLogger.log(severity, message, exception);
			break;
		case "warning":
			if (warningLogger != null) warningLogger.log(severity, message, exception);
			break;
		case "info":
			if (warningLogger != null) infoLogger.log(severity, message, exception);
			break;
		default:
			System.out.println("We don't recognize this severity level");
			break;
		}
		
	}
	
	public void setLogger(String severity, ILogger logger) {
		switch (severity) {
		case "error":
			errorLogger = logger;
			break;
		case "warning":
			warningLogger = logger;
			break;
		case "info":
			infoLogger = logger;
			break;
		default:
			System.out.println("We don't recognize this severity level");
			break;
		}
			
	}

}
