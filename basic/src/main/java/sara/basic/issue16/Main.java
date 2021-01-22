package sara.basic.issue16;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int size = getSquareSize();
		int[] squareShape = createSquareShape(size);

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

}