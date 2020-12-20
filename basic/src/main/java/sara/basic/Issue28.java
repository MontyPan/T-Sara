package sara.basic;

import java.util.Scanner;

public class Issue28 {

	public static void main(String[] args) {

		// 輸入玩家人數，二人玩一人發 12 張，三人玩一人發 8 張，四人玩一人發 6 張
		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入遊戲人數：2~4");
		int playersSum = sc.nextInt();
		while (playersSum <= 1 || playersSum >= 5) {
			System.out.println("請重新輸入人數");
			playersSum = sc.nextInt();
		}

		if (playersSum == 2) {
			int[][] players = new int[2][12];
			System.out.println("兩人遊戲開始~");
		} else if (playersSum == 3) {
			int[][] players = new int[3][8];
			System.out.println("三人遊戲開始~");
		} else if (playersSum == 4) {
			int[][] players = new int[4][6];
			System.out.println("四人遊戲開始~");
		}

	}
}