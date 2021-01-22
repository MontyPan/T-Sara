package sara.basic.issue16;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int size = getSquareSize();
		int[] squareShape = createSquareShape(size);

		drawSquare(size, squareShape);
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

	public static void drawSquare(int size, int[] finalSquare) {
		for (int i = 0; i < finalSquare.length; i++) {
			if ((i % size) == 0) {
				System.out.println();
			}
			System.out.print(finalSquare[i] + "\t");
		}
	}
}