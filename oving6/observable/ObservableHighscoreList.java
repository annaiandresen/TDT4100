package patterns.observable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ObservableHighscoreList extends ObservableList{
	
	private List<ObservableListListener> listeners;
	private List<Integer> list;
	private int maxSize;
	
	public ObservableHighscoreList(int maxSize) {
		if (maxSize <= 0) throw new IllegalArgumentException("Maxsize must be greater than 0");
		this.maxSize = maxSize;
		
		listeners = new ArrayList<>();
		list = new ArrayList<>();
	}
	
	public int size() {
		return list.size();
	}
	
	public int getElement(int position) {
		return list.get(position);
	}
	
	/**
	 * Register a new result, and if the result is good enough to make the list it will be put in the correct position.
	 * If the list size exceeds maxSize, the worst result has to be discarded. 
	 * All registered listeners must be notified of changes in position
	 * @param result The result that is registered
	 */
	public void addResult(int result) {
		// If the list is too long
		if (!checkMaxSize() && (result <= list.get(size() - 1))) {
			list.remove(list.size() - 1);
			list.add(result);
			sort(list);
			fireChangeListeners(result);
		} else if (checkMaxSize()) {
			list.add(result);
			sort(list);
			fireChangeListeners(result);
		} 
	}
	
	//Observable
	public void addObservableListListener(ObservableListListener listener) {
		if (!listeners.contains(listener))
			listeners.add(listener);
	}
	
	public void removeObservableListListener(ObservableListListener listener) {
		if(listeners.contains(listener))
			listeners.remove(listener);
	}
	
	private boolean checkMaxSize() {
		return size() < maxSize;
	}
	
	private void fireChangeListeners(int element) {
		listeners.stream().forEach(l -> l.listChanged(this, list.indexOf(element)));
	}
	
	private void sort(List<Integer> list){
		Collections.sort(list);
	}
	
	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i<list.size(); i++) {
			str += list.get(i)+" ";
		}
		return str;
	}
	
	public static void main(String[] args) {
		ObservableHighscoreList hsList = new ObservableHighscoreList(3);
		int pos1 = -1;
		int pos2 = -1;
		
		hsList.addResult(1);
		hsList.addResult(2);
		hsList.addResult(3);
		System.out.println(hsList);
	}

}
