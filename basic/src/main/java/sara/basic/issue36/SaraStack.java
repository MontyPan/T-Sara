package sara.basic.issue36;

public class SaraStack {
	private String[] array;
	private int top;

	public SaraStack() {
		array = new String[0];
	}

	public void push(String value) {
		if (array.length > 0) {
			top = array.length - 1;
		}
		// array 只儲存舊的
		String[] newArr = new String[array.length + 1];
		// newArr 複製 Array 的值
		for (int i = 0; i < array.length; i++) {
			newArr[i] = array[i];
		}
		// newArr 再加一個新的
		newArr[newArr.length - 1] = value;
		// array 複製 newArr
		array = new String[newArr.length];
		for (int i = 0; i < newArr.length; i++) {
			array[i] = newArr[i];
		}
		top = array.length - 1;
	}

	public String pop() {
		if (array.length > 0) {
			String last = array[top];
			String[] newArr = new String[array.length - 1];
			// newArr 複製 Array.length-1 的值
			for (int i = 0; i < newArr.length; i++) {
				newArr[i] = array[i];
			}
			// array 複製 newArr
			array = new String[newArr.length];
			for (int i = 0; i < newArr.length; i++) {
				array[i] = newArr[i];
			}
			top = array.length - 1;
			return last;
		}
		return "It's empty 此罐以空";
	}

	public String peek() {
		if (array.length > 0) {
			return array[top];
		}
		return "It's empty 此罐以空";
	}
}
