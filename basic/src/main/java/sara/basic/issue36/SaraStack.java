package sara.basic.issue36;

public class SaraStack {
	private String[] array;
	private int top;

	public SaraStack() {
		array = new String[0];
	}

	/**
	 * @param value 使用者輸入的字串
	 */
	public void push(String value) {
		boolean noPlace = true;
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals("")) {
				array[i] = value;
				top = i;
				noPlace = false;
				break;
			}
		}
		if (noPlace) {
			String[] newArr = new String[array.length + 1];
			copyArrayData(newArr, array, array.length, value);
			top = array.length - 1;
		}
	}

	/**
	 * @return array[top] or 提示錯誤訊息
	 */
	public String pop() {
		if (array.length <= 0 || array[top].equals("")) {
			return "It's empty 此罐已空";
		}
		String last = array[top];
		array[top] = "";
		if (top == 0) {
			return last;
		}
		top--;
		return last;
	}

	/**
	 * @return array[top] or 提示錯誤訊息
	 */
	public String peek() {
		if (array.length <= 0) {
			return "It's empty 此罐已空";
		} else {
			return array[top];
		}
	}

	/**
	 * @param tempArray 用新陣列長度做初始化的陣列，用以讓 array 以新長度重新初始化
	 * @param oldArray 原陣列長度 {@link SaraStack#array}}
	 * @param arrayLength 新陣列長度 = 原陣列長度 +1
	 * @param value 使用者輸入的字串
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