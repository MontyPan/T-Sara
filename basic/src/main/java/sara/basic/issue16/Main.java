package sara.basic.issue16;

import java.util.Scanner;

public class Main {
	int squareSize;
	int[] finalSquare;
	int x;
	int y;

	public static void main(String[] args) {
		// 獲得大小
		Main m = new Main();
		m.getSquareSize();
		// 將大小給製作方陣的 method 使用
		m.putIntoNumber();
		m.printSquare();
	}

	public void getSquareSize() {
		System.out.println("請輸入方陣大小");
		Scanner sc = new Scanner(System.in);
		squareSize = sc.nextInt();
	}

	public void putIntoNumber() {
		finalSquare = new int[squareSize * squareSize];

		// 先把 1 填入 first row 的中間
		finalSquare[squareSize / 2] = 1;
		x = squareSize / 2;
		y = 0;
		for (int i = 2; i <= finalSquare.length; i++) {
			if (i % squareSize == 1) {
				y++;
				checkSame(i);
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
		}
	}

	public void checkSame(int currentNum) {
		int temp = x + (squareSize * y);
		finalSquare[temp] = currentNum;
	}

	public void printSquare() {
		for (int i = 0; i < finalSquare.length; i++) {
			if (((i % squareSize) == 0) && (i > 1)) {
				System.out.println();
			}
			System.out.print(finalSquare[i] + "\t");
		}
	}

}