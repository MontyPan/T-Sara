package sara.basic.issue16;

import java.util.Scanner;

public class Main {
	static int squareSize;

	public static void main(String[] args) {
		// 獲得大小
		getSquareSize();
		// 將大小當參數傳給製作方陣的 method
		
	}
	
	public static int getSquareSize() {
		System.out.println("請輸入方陣大小");
		Scanner sc = new Scanner(System.in);
		squareSize = sc.nextInt();
		return squareSize;
	}
}
