package sara.basic.issue16;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int size = getSquareSize();
		int[] squareShape = createSquareShape(size);
		int[] finalSquare = fillInNumber(squareShape, size);

		drawSquare(size, finalSquare);
	}

	/**
	 * @return 尺寸
	 */
	public static int getSquareSize() {
		Scanner sc = new Scanner(System.in);
		int typeInNum = sc.nextInt();
		return typeInNum;
	}

	/**
	 * @param size
	 * @return 根據使用者輸入的尺寸形成的空方陣（只有預設值）
	 */
	public static int[] createSquareShape(int size) {
		int[] squareShape = new int[size * size];
		return squareShape;
	}

	/**
	 * @param squareShape
	 * @param size
	 * @return 填完數字的方陣
	 */
	public static int[] fillInNumber(int[] squareShape, int size) {
		int[] finalSquare = squareShape;
		// 先把 1 填入 first row 的中間
		finalSquare[size / 2] = 1;
		// 宣告 x, y
		int x = size / 2;
		int y = 0;
		int oldX;
		int oldY;
		int temp;
		// 從 2 開始填入數字
		for (int i = 2; i <= finalSquare.length; i++) {
			// 加入填入的規則
			oldX = x;
			oldY = y;
			x++;
			y--;
			x = checkXRule(x, size);
			y = checkYRule(y, size);
			temp = x + (size * y);
			if (finalSquare[x + (size * y)] > 0) {
				x = oldX;
				y = oldY;
				y++;
				x = checkXRule(x, size);
				y = checkYRule(y, size);
				temp = x + (size * y);
				finalSquare[temp] = i;
				continue;
			}
			finalSquare[temp] = i;
		}

		return finalSquare;
	}

	/**
	 * @param size
	 * @param finalSquare
	 */
	public static void drawSquare(int size, int[] finalSquare) {
		for (int i = 0; i < finalSquare.length; i++) {
			if ((i % size) == 0 && i > 0) {
				System.out.println();
			}
			System.out.print(finalSquare[i] + "\t");
		}
	}

	/**
	 * @param x
	 * @param size
	 * @return 調整超出方陣邊境的 x 的數值
	 */
	public static int checkXRule(int x, int size) {
		if (x < 0) {
			x += size;
		}

		if (x > (size - 1)) {
			x = 0;
		}
		return x;
	}

	/**
	 * @param y
	 * @param size
	 * @return 調整超出方陣邊境的 y 的數值
	 */
	public static int checkYRule(int y, int size) {
		if (y < 0) {
			y += size;
		}

		if (y > (size - 1)) {
			y = 0;
		}
		return y;
	}
}