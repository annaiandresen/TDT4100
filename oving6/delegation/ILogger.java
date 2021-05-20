package patterns.delegation;

public interface ILogger {
	
	public final String ERROR = "error", WARNING = "warning", INFO = "info";
	
	
	/**
	 * Gives a log of happenings. Usually in a try/catch
	 * @param severity The severity of the message, must be one of the error messages listed as constants.
	 * @param message A message which tells the user what went wrong
	 * @param exception The exception type, can be null
	 */
	public void log(String severity, String message, Exception exception) throws Exception;
}
