package sara.basic.issue36;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SaraStack {
	private String[] array;
	private int top;

	public SaraStack() {
		array = new String[0];
	}

	public void push(String value) {
		List<String> tempList = new ArrayList<String>(Arrays.asList(array));
		tempList.add(value);
		array = tempList.toArray(new String[tempList.size()]);
		top = array.length - 1;
	}

	public String pop() {
		if (array.length > 0) {
			String last = array[top];
			List<String> tempList = new ArrayList<String>(Arrays.asList(array));
			tempList.remove(array[top]);
			array = tempList.toArray(new String[tempList.size()]);
			top = array.length - 1;
			return last;
		}
		return "It's empty";
	}

	public String peek() {
		if (array.length > 0) {
			return array[top];
		}
		return "It's empty";
	}
}
