package sara.basic.issue16;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int size = getSquareSize();
		int[] squareShape = createSquareShape(size);
		int[] finalSquare = fillInNumber(squareShape, size);

		drawSquare(size, finalSquare);
	}

	public static int getSquareSize() {
		Scanner sc = new Scanner(System.in);
		int typeInNum = sc.nextInt();
		return typeInNum;
	}

	public static int[] createSquareShape(int size) {
		int[] squareShape = new int[size * size];
		return squareShape;
	}

	public static int[] fillInNumber(int[] squareShape, int size) {
		int[] finalSquare = squareShape;
		// 先把 1 填入 first row 的中間
		finalSquare[size / 2] = 1;
		// 宣告 x, y
		int x = size / 2;
		int y = 0;
		// 從 2 開始填入數字
		for (int i = 2; i <= finalSquare.length; i++) {
			// 加入填入的規則
			if ((i % size) == 1) {
				y++;
				continue;
			}
			x++;
			y--;

			if (x < 0) {
				x += size;
			} else if (y < 0) {
				y += size;
			}

			if (x > 2) {
				x = 0;
			} else if (y > 2) {
				y = 0;
			}

			// 開始填入
			
			
		}

		System.out.println(Arrays.toString(finalSquare));
		return finalSquare;
	}

	public static void drawSquare(int size, int[] finalSquare) {
		for (int i = 0; i < finalSquare.length; i++) {
			if ((i % size) == 0 && i > 0) {
				System.out.println();
			}
			System.out.print(finalSquare[i] + "\t");
		}
	}
}