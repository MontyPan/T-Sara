package sara.basic.issue36;

public class SaraStack {
	private String[] array;
	private int top;

	public SaraStack() {
		array = new String[0];
	}

	public void push(String value) {
		// array 只儲存舊的
		String[] newArr = new String[array.length + 1];
		// newArr 複製 array 的值
		copyArrayData(newArr, array, array.length);
		// newArr 再加一個新的
		newArr[newArr.length - 1] = value;
		// array 複製 newArr
		array = new String[newArr.length];
		copyArrayData(array, newArr, newArr.length);
		top = array.length - 1;
	}

	public String pop() {
		if (array.length <= 0) {
			return "It's empty 此罐已空";
		}
		String last = array[top];
		String[] newArr = new String[array.length - 1];
		// newArr 複製 array.length-1 的值
		copyArrayData(newArr, array, newArr.length);
		// array 複製 newArr
		array = new String[newArr.length];
		copyArrayData(array, newArr, newArr.length);
		top = array.length - 1;
		return last;
	}

	public String peek() {
		if (array.length <= 0) {
			return "It's empty 此罐已空";
		} else {
			return array[top];
		}
	}

	public void copyArrayData(String[] arrayOne, String[] arrayTwo, int arrayLength) {
		// arrayOne 複製 newArray 的值
		for (int i = 0; i < arrayLength; i++) {
			arrayOne[i] = arrayTwo[i];
		}
	}
}