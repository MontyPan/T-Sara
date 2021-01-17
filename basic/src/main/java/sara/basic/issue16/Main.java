package sara.basic.issue16;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int squareSize;

	public static void main(String[] args) {
		// 獲得大小
		getSquareSize();
		// 將大小給製作方陣的 method 使用
		int[] cube = createSquareWithNumber();
		for (int i = 1; i <= cube.length; i++) {
			if ((i % squareSize) == 0) {
				System.out.print(cube[i - 1] + "\n");
			} else {
				System.out.print(cube[i - 1] + "\t");
			}
		}
	}

	public static int getSquareSize() {
		System.out.println("請輸入方陣大小");
		Scanner sc = new Scanner(System.in);
		squareSize = sc.nextInt();
		return squareSize;
	}

	public static int[] createSquareWithNumber() {
		// 只能做出 3 x 3 的方陣
		int middleNum = (squareSize * 2) - 1;
		int[] square = new int[squareSize * squareSize];
		square[square.length / 2] = middleNum;
		square[(square.length / 2) - 1] = middleNum - 2;
		square[(square.length / 2) + 1] = middleNum + 2;
		square[(square.length / 2) - 2] = middleNum + 1;
		square[(square.length / 2) + 2] = middleNum - 1;
		square[(square.length / 2) - 3] = middleNum - 4;
		square[(square.length / 2) + 3] = middleNum + 4;
		square[(square.length / 2) - 4] = middleNum + 3;
		square[(square.length / 2) + 4] = middleNum - 3;
		System.out.println(Arrays.toString(square));
		return square;
	}
}
