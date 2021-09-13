package stateandbehavior;

public class StopWatch {
	private boolean start, stop = false; //forteller om klokka har startet eller stoppet
	private int ticks, time, lastLapTime;
	
	public StopWatch() {
		ticks = 0;
		time = 0;
		lastLapTime = -1;
	}
	
	public int getTicks() {
		return ticks;
	}

	public int getTime() {
		if (!isStarted()) {
			return -1-1-1;
		}
		if(isStopped()) {
			return ticks;
		} else if (start && (!stop)) {
			return ticks;
		}
		return time;
	}
	
	
	public boolean isStarted() {
		return start;
	}
	
	public boolean isStopped() {
		return stop;
	}
	public int getLapTime() {
		if (isStarted()) {
			return time;
		}
		else {
			return -1;
		}
	}
	
	public int getLastLapTime() {
		if (lastLapTime > 0) {
			return lastLapTime;
		} else {
			return -1;
		}
	}
	
	//For å endre tilstanden
	public void tick(int ticks) {
		if (ticks < 0) {
			// kan ikke legge til negative ticks
			throw new IllegalArgumentException();
		} else if (isStarted() && !isStopped()){
			time += ticks;			
		}
		this.ticks += ticks;
	}
	
	public void start() {
		if (isStarted() || isStopped()) {
			throw new IllegalStateException("Invalid: start");
		} 
		
		else {
		start = true;
		time = 0;
		}
	}
	

	public void lap() {
		//denne kan bare kjøre dersom start er true
		if(isStopped() || !isStarted()) {
			throw new IllegalStateException("Invalid: lap");
		}
		
		lastLapTime = getLapTime();
	}
	
	public void stop() {
		//denne kan bare kjøre dersom klokka er startet
		if (isStarted() && !isStopped()) {
			stop = true;
			lap();
		}
		else {
			throw new IllegalStateException();
		}
	}
	
	@Override
	public String toString() {
		return "Time: " + time + "\nLast lap time: " + lastLapTime;
	}
	
	public static void main(String[] args) {
		StopWatch sw = new StopWatch();
		sw.start();
		System.out.println(sw);
		sw.tick(3);
		System.out.println(sw);
		sw.lap();
		System.out.println(sw);
	}
}
	