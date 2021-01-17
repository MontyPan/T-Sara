package sara.basic.issue16;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int squareSize = 3;
	static String[] square;
	static String temp;
	static int x;
	static int y;

	public static void main(String[] args) {
		// 獲得大小
		getSquareSize();
		// 將大小給製作方陣的 method 使用
		String[] cube = createSquareWithNumber();
		for (int i = 1; i <= cube.length; i++) {
			if ((i % squareSize) == 0) {
				cube[i - 1] += "\n";
			} else {
				cube[i - 1] += "\t";
			}
		}
		System.out.println(Arrays.toString(cube));
	}

	public static int getSquareSize() {
		System.out.println("請輸入方陣大小");
		Scanner sc = new Scanner(System.in);
		squareSize = sc.nextInt();
		return squareSize;
	}

	public static String[] createSquareWithNumber() {
		square = new String[squareSize * squareSize];
		// 填入座標值
		for (int y = 0; y < squareSize; y++) {
			for (int x = 0; x < squareSize; x++) {
				square[(squareSize * y) + x] = x + ":" + y;
			}
		}
		System.out.println(Arrays.toString(square));

		// 先把 1 填入 first row 的中間
		square[squareSize / 2] = "1";
		x = squareSize / 2;
		y = 0;
		for (int i = 2; i <= square.length; i++) {
			if (i % squareSize == 1) {
				y++;
				checkSame(i);
				System.out.println(i + " con=> " + temp);
				continue;
			}

			x--;
			y--;
			if (x < 0) {
				x += squareSize;
			} else if (y < 0) {
				y += squareSize;
			}

			checkSame(i);

			System.out.println(i + " => " + temp);
		}
		System.out.println(Arrays.toString(square));
		return square;
	}

	public static void checkSame(int currentNum) {
		temp = x + ":" + y;
		for (int i = 0; i < square.length; i++) {
			if (temp.equals(square[i])) {
				square[i] = currentNum + "";
			}
		}
	}
}
