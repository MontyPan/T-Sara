package sara.basic.pickred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Issue28 {

	public static void main(String[] args) {

		// 輸入玩家人數
		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入遊戲人數：2~4");
		int playersSum = sc.nextInt();
		while (playersSum <= 1 || playersSum >= 5) {
			System.out.println("請重新輸入人數");
			playersSum = sc.nextInt();
		}

		// 總共 4 花色 A~K = 52 張牌
		// 黑桃、梅花(不計分)、紅心(紅)、方塊(紅)

		// 生成花色 & 牌
		String[] suit = { "♥", "♦", "♣", "♠" };
		int[] cards = new int[13];
		String[][] temp = new String[4][13];
		String[] poker = new String[52];
		// 把每張牌加入花色
		for (int i = 0; i < suit.length; i++) {
			for (int i2 = 0; i2 < cards.length; i2++) {
				cards[i2] = i2 + 1;
				temp[i][i2] = suit[i] + cards[i2];
			}
		}
		// 把加入花色的牌放入 poker 中
		for (int i = 0; i < poker.length; i++) {
			poker[i] = temp[i % 4][i / 4];
		}

		// 洗牌
		String[] shuffledPoker = new String[52];
		for (int i = 0; i < shuffledPoker.length; i++) {
			int rand;
			boolean isSame;
			// 避免重複
			do {
				rand = (int) (Math.random() * 52);
				isSame = false;
				for (int i2 = 0; i2 < i; i2++) {
					if (shuffledPoker[i2] == poker[rand]) {
						isSame = true;
						break;
					}
				}
			} while (isSame);

			shuffledPoker[i] = poker[rand];
		}

		// 依照玩家人數發牌，二人玩一人發 12 張，三人玩一人發 8 張，四人玩一人發 6 張
		String[][] players = null;
		if (playersSum == 2) {
			System.out.println("兩人遊戲開始~");
			players = new String[2][12];
			for (int i2 = 0; i2 < players[0].length; i2++) {
				players[0][i2] = shuffledPoker[i2];
				players[1][i2] = shuffledPoker[i2 + (1 * players[1].length)];
				shuffledPoker[i2] = "0";
				shuffledPoker[i2 + (1 * players[1].length)] = "0";
			}
		} else if (playersSum == 3) {
			System.out.println("三人遊戲開始~");
			players = new String[3][8];
			for (int i2 = 0; i2 < players[0].length; i2++) {
				players[0][i2] = shuffledPoker[i2];
				players[1][i2] = shuffledPoker[i2 + (1 * players[1].length)];
				players[2][i2] = shuffledPoker[i2 + (2 * players[1].length)];
				shuffledPoker[i2] = "0";
				shuffledPoker[i2 + (1 * players[1].length)] = "0";
			}
		} else if (playersSum == 4) {
			System.out.println("四人遊戲開始~");
			players = new String[4][6];
			for (int i2 = 0; i2 < players[0].length; i2++) {
				players[0][i2] = shuffledPoker[i2];
				players[1][i2] = shuffledPoker[i2 + (1 * players[1].length)];
				players[2][i2] = shuffledPoker[i2 + (2 * players[1].length)];
				players[3][i2] = shuffledPoker[i2 + (3 * players[1].length)];
				shuffledPoker[i2] = "0";
				shuffledPoker[i2 + (1 * players[1].length)] = "0";
			}
		}

		// 每個玩家擁有的手牌
		for (String[] player : players) {
			for (String card : player) {
				System.out.print(card + "\t");
			}
			System.out.println();
		}

		// 把發出去的牌的空間與元素移除
		List<String> tempList = new ArrayList<String>(Arrays.asList(shuffledPoker));
		for (int i = 0; i < shuffledPoker.length; i++) {
			if (shuffledPoker[i] == "0") {
				tempList.remove("0");
			}
		}
		shuffledPoker = tempList.toArray(new String[tempList.size()]);
		System.out.println(Arrays.toString(shuffledPoker));
	}

}
