package patterns.observable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class HighscoreList {
	
	private List<Integer> results;
	private int maxSize;
	private Collection<HighscoreListListener> listeners;
	
	public HighscoreList(int maxSize) {
		if (maxSize <= 0 ) {
			throw new IllegalArgumentException("MaxSize has to be bigger than 1");
		}
		
		this.maxSize = maxSize;
		results = new ArrayList<>();
		listeners = new ArrayList<>();
	}
	
	public int size() {
		return results.size();
	}
	
	public int getElement(int index) {
		if (index < 0 || index > maxSize) {
			throw new IllegalArgumentException("Invalid position");
		}
		return results.get(index);
	}

	public void addResult(int result) {
		results.add(result);
		sortList();
		if (results.size() > maxSize) {
			results.remove(results.size() - 1);
		}
		for (int i = 0; i < results.size(); i++) {
			if (getElement(i) == result) {
				fireChangeListeners(i);
			}
		}
	}
	
	private void sortList() {
		results = results.stream().sorted((o1, o2) -> o1 - o2).collect(Collectors.toList());
	}
	
	
	public void addHighscoreListListener(HighscoreListListener listener) {
		if (!listeners.contains(listener)) {
			listeners.add(listener);
		}
	}
	
	public void removeHighscoreListListener(HighscoreListListener listener) {
		if (listeners.contains(listener)) {
			listeners.remove(listener);
		}
	}
	
	private void fireChangeListeners(int index) {
		for (HighscoreListListener listener : listeners) {
			listener.listChanged(this, index);
		}
	}
	
	@Override
	public String toString() {
		String out = "";
		int counter = 1;
		for (int r : results) {
			out += counter + ": " + r + "\n";
			counter++;
		}
		return out;
	}
}
