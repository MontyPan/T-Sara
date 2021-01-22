package sara.basic.issue16;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int size = getSquareSize();

	}

	public static int getSquareSize() {
		Scanner sc = new Scanner(System.in);
		int typeInNum = sc.nextInt();
		return typeInNum;
	}

}