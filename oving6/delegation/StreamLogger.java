package patterns.delegation;

import java.io.OutputStream;

public class StreamLogger implements ILogger {
	private String formatString; //formats texts
	private OutputStream stream; //stream where log messages are written
	
	/**
	 * Initializes the StreamLogger object, log messages writes to stream
	 * @param stream
	 */
	public StreamLogger(OutputStream stream) {
		formatString = "%s: %s (%s)";
		this.stream = stream;
	}

	@Override
	public void log(String severity, String message, Exception exception) throws Exception {
		String logMessage = String.format(formatString, severity, message, exception);
		
		try {
			this.stream.write(logMessage.getBytes());
			
		} catch (Exception e) {
			log(ILogger.ERROR, e.getStackTrace().toString(), e);
			
		}
		finally {
			this.stream.flush();
		}
		
	}
	
	/**
	 * Sets new format string
	 * @param formatString
	 */
	public void setFormatString(String formatString) {
		this.formatString = formatString;
	}

}
