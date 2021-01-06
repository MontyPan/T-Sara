package sara.basic.issue36;

public class SaraStack {
	private String[] array;
	private int top;

	public SaraStack() {
		array = new String[0];
	}
	
	/**
	 * @param value
	 */
	public void push(String value) {
		String[] newArr = new String[array.length + 1];
		copyArrayData(newArr, array, array.length, value);
		top = array.length - 1;
	}

	/**
	 * @return
	 */
	public String pop() {
		if (array.length <= 0) {
			return "It's empty 此罐已空";
		}
		String last = array[top];
		String[] newArr = new String[array.length - 1];
		copyArrayData(newArr, array, newArr.length, "");
		top = array.length - 1;
		return last;
	}

	/**
	 * @return
	 */
	public String peek() {
		if (array.length <= 0) {
			return "It's empty 此罐已空";
		} else {
			return array[top];
		}
	}

	/**
	 * @param tempArray
	 * @param oldArray
	 * @param arrayLength
	 * @param value
	 */
	public void copyArrayData(String[] tempArray, String[] oldArray, int arrayLength, String value) {
		// tempArray 複製 oldArray 的值
		for (int i = 0; i < arrayLength; i++) {
			tempArray[i] = oldArray[i];
		}
		if (!value.equals("")) {
			tempArray[tempArray.length - 1] = value;
		}
		// array 複製 tempArray 的值
		array = new String[tempArray.length];
		for (int i = 0; i < tempArray.length; i++) {
			array[i] = tempArray[i];
		}
	}
}