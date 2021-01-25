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
	 * 取得方陣的尺寸
	 * 
	 * @return 方陣的尺寸
	 */
	public static int getSquareSize() {
		Scanner sc = new Scanner(System.in);
		int typeInNum = sc.nextInt();
		return typeInNum;
	}

	/**
	 * 用 getSquareSize() 取得的 size 建立只有預設值的空方陣
	 * 
	 * @param size 方陣的尺寸
	 * @return size * size 的空方陣
	 */
	public static int[] createSquareShape(int size) {
		int[] squareShape = new int[size * size];
		return squareShape;
	}

	/**
	 * 以座標邏輯將數字依序填入空方陣
	 * 
	 * @param squareShape createSquareShape() 得到的空方陣 
	 * @param size 方陣的尺寸
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
	 * 印出填完數字的方陣
	 * 
	 * @param size 方陣的尺寸
	 * @param finalSquare fillInNumber() 取得的填完數字的方陣
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
	 * 判斷與調整超出邊界的座標（x）
	 * 
	 * @param x 座標（x）
	 * @param size 方陣的尺寸
	 * @return 邊界內的 x 的數值
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
	 * 判斷與調整超出邊界的座標（y）
	 * 
	 * @param y 座標（y）
	 * @param size 方陣的尺寸
	 * @return 邊界內的 y 的數值
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