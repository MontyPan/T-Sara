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
		String[] suits = { "♥", "♦", "♣", "♠" };
		int[] cards = new int[13];
		String[][] temp = new String[4][13];
		String[] poker = new String[52];
		// 把每張牌加入花色
		for (int i = 0; i < suits.length; i++) {
			for (int i2 = 0; i2 < cards.length; i2++) {
				cards[i2] = i2 + 1;
				temp[i][i2] = suits[i] + cards[i2];
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
		// 將字串統一長度
		for (int i = 0; i < shuffledPoker.length; i++) {
			if (shuffledPoker[i].length() <= 2) {
				shuffledPoker[i] += " ";
			}
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
				players[2][i2] = shuffledPoker[i2 + (2 * players[2].length)];
				shuffledPoker[i2] = "0";
				shuffledPoker[i2 + (1 * players[1].length)] = "0";
				shuffledPoker[i2 + (2 * players[2].length)] = "0";
			}
		} else if (playersSum == 4) {
			System.out.println("四人遊戲開始~");
			players = new String[4][6];
			for (int i2 = 0; i2 < players[0].length; i2++) {
				players[0][i2] = shuffledPoker[i2];
				players[1][i2] = shuffledPoker[i2 + (1 * players[1].length)];
				players[2][i2] = shuffledPoker[i2 + (2 * players[2].length)];
				players[3][i2] = shuffledPoker[i2 + (3 * players[3].length)];
				shuffledPoker[i2] = "0";
				shuffledPoker[i2 + (1 * players[1].length)] = "0";
				shuffledPoker[i2 + (2 * players[2].length)] = "0";
				shuffledPoker[i2 + (3 * players[3].length)] = "0";
			}
		}

		// 每個玩家擁有的手排
		for (String[] player : players) {
			for (String card : player) {
				System.out.print(card + ",");
			}
			System.out.println();
		}

		// 把發出去的牌的空間與元素移除
		List<String> tempShuffledList = new ArrayList<String>(Arrays.asList(shuffledPoker));
		for (int i = 0; i < shuffledPoker.length; i++) {
			if (shuffledPoker[i] == "0") {
				tempShuffledList.remove("0");
			}
		}
		shuffledPoker = tempShuffledList.toArray(new String[tempShuffledList.size()]);
		// 翻出剩餘的牌前四張於桌面
		// 海底翻開的牌
		String[] showedPoker = new String[4];
		for (int i = 0; i < 4; i++) {
			showedPoker[i] = shuffledPoker[i];
			shuffledPoker[i] = "0";
			System.out.print("海底牌：" + showedPoker[i]);
		}
		System.out.println();
		// 把翻出的牌的空間與元素移除
		tempShuffledList = new ArrayList<String>(Arrays.asList(shuffledPoker));
		for (int i = 0; i < shuffledPoker.length; i++) {
			if (shuffledPoker[i] == "0") {
				tempShuffledList.remove("0");
			}
		}
		shuffledPoker = tempShuffledList.toArray(new String[tempShuffledList.size()]);
		System.out.println("第一次洗牌\n" + Arrays.toString(shuffledPoker));
		// 遊戲開始：輪流打出手牌
		// 計分板
		int[] score = new int[players.length];

		for (int i = 0; i < showedPoker.length; i++) {
			for (int i2 = 0; i2 < players.length; i2++) {
				for (int i3 = 0; i3 < players[i2].length; i3++) {
					List<String> tempShowedList;
					List<String> tempPlayerPokerList;
					int numberFromPlayer = Integer.parseInt(players[i2][i3].substring(1).trim());
					int numberFromShowed = Integer.parseInt(players[i2][i3].substring(1).trim());

					String suitsFromPlayer = players[i2][i3].substring(0, 1);
					String suitsFromShowed = showedPoker[i].substring(0, 1);

					if ((numberFromPlayer + numberFromShowed) == 10) {
						System.out.printf("第一玩家%d：%d與海底的%d配對\n", i2, numberFromPlayer, numberFromShowed);
						// 判斷計分
						if (suitsFromPlayer.equals("♥") || suitsFromPlayer.equals("♦")) {
							score[i2] += numberFromPlayer;
						}
						if (suitsFromShowed.equals("♥") || suitsFromShowed.equals("♦")) {
							score[i2] += numberFromShowed;
						}
						if (players[i2][i3].trim().equals("♠1") || showedPoker[i].trim().equals("♠1")) {
							score[i2] += 30;
						}
						if (players[i2][i3].trim().equals("♥1") || showedPoker[i].trim().equals("♥1")) {
							score[i2] += 20;
						}
						if (players[i2][i3].trim().equals("♦1") || showedPoker[i].trim().equals("♦1")) {
							score[i2] += 20;
						}
						// 把配對成功的兩張牌丟掉
						// 翻出一張牌
						players[i2][i3] = "0";
						tempPlayerPokerList = new ArrayList<String>(Arrays.asList(players[i2]));
						tempPlayerPokerList.remove("0");
						players[i2] = tempPlayerPokerList.toArray(new String[tempPlayerPokerList.size()]);
						System.out.println("玩家" + i2 + "的手牌： " + Arrays.toString(players[i2]));
						showedPoker[i] = "0";
						tempShowedList = new ArrayList<String>(Arrays.asList(showedPoker));
						tempShowedList.remove("0");
						tempShowedList.add(shuffledPoker[0]);

						showedPoker = tempShowedList.toArray(new String[tempShowedList.size()]);

						System.out.println("海底： " + Arrays.toString(showedPoker));
						shuffledPoker[0] = "0";
						tempShuffledList = new ArrayList<String>(Arrays.asList(shuffledPoker));
						tempShuffledList.remove("0");
						shuffledPoker = tempShuffledList.toArray(new String[tempShuffledList.size()]);
						System.out.println("配對後洗牌： " + Arrays.toString(shuffledPoker));
						// 判斷翻出的這張牌是否可跟手牌湊
						// 可以：把配對成功的兩張牌丟掉
						// 判斷計分 - 誰得幾分
						// 不行：放置海底
						// 換下一位
						break;
					} else if (numberFromPlayer >= 9 || numberFromShowed >= 9) {
						if (numberFromPlayer == numberFromShowed) {
							// 判斷計分
							if (suitsFromPlayer.equals("♥") || suitsFromPlayer.equals("♦")) {
								score[i2] += 10;
								System.out.printf("第二玩家%d：%d與海底的%d配對\n", i2, numberFromPlayer, numberFromShowed);
							}
							if (suitsFromShowed.equals("♥") || suitsFromShowed.equals("♦")) {
								score[i2] += 10;
								System.out.printf("第三玩家%d：%d與海底的%d配對\n", i2, numberFromPlayer, numberFromShowed);
							}
							// 把配對成功的兩張牌丟掉
							// 翻出一張牌
							players[i2][i3] = "0";
							tempPlayerPokerList = new ArrayList<String>(Arrays.asList(players[i2]));
							tempPlayerPokerList.remove("0");
							players[i2] = tempPlayerPokerList.toArray(new String[tempPlayerPokerList.size()]);
							System.out.println("玩家" + i2 + "的手牌： " + Arrays.toString(players[i2]));
							showedPoker[i] = "0";
							tempShowedList = new ArrayList<String>(Arrays.asList(showedPoker));
							tempShowedList.remove("0");
							tempShowedList.add(shuffledPoker[0]);
							showedPoker = tempShowedList.toArray(new String[tempShowedList.size()]);
							System.out.println("海底： " + Arrays.toString(showedPoker));

							shuffledPoker[0] = "0";
							tempShuffledList = new ArrayList<String>(Arrays.asList(shuffledPoker));
							tempShuffledList.remove("0");
							shuffledPoker = tempShuffledList.toArray(new String[tempShuffledList.size()]);
							System.out.println("配對後洗牌： " + Arrays.toString(shuffledPoker));
							// 判斷這張是否可跟手牌湊
							// 可以：把配對成功的兩張牌丟掉
							// 判斷計分 - 誰得幾分
							// 不行：放置海底
							// 換下一位
							break;
						}
					} else {
						// (玩家手中"沒牌"可湊)
						// 打出一張手牌到海底
						System.out.printf("第四玩家%d：沒牌出\n", i2);
						String toShowedPoker = players[i2][i3];
						players[i2][i3] = "0";
						tempPlayerPokerList = new ArrayList<String>(Arrays.asList(players[i2]));
						tempPlayerPokerList.remove("0");
						players[i2] = tempPlayerPokerList.toArray(new String[tempPlayerPokerList.size()]);
						System.out.println("玩家" + i2 + "的手牌： " + Arrays.toString(players[i2]));
						// 翻出一張牌
						tempShowedList = new ArrayList<String>(Arrays.asList(showedPoker));
						tempShowedList.add(toShowedPoker);
						tempShowedList.add(shuffledPoker[0]);
						showedPoker = tempShowedList.toArray(new String[tempShowedList.size()]);
						System.out.println("海底： " + Arrays.toString(showedPoker));
						shuffledPoker[0] = "0";
						tempShuffledList = new ArrayList<String>(Arrays.asList(shuffledPoker));
						tempShuffledList.remove("0");
						shuffledPoker = tempShuffledList.toArray(new String[tempShuffledList.size()]);
						System.out.println("配對後洗牌： " + Arrays.toString(shuffledPoker));
						// 判斷這張是否可跟手牌湊
						// 可以：把配對成功的兩張牌丟掉
						// 判斷計分 - 誰得幾分
						// 不行：放置海底
						// 換下一位
						break;
					}
				}
			}
		}
						// =遊戲結束條件=
						// if 所有海底牌都被取完 && 所有玩家手牌都打出
						// 分數高的獲勝
						// =計分條件=
						// 黑桃 A = 30
						// 紅心 A ,方塊A = 20
						// 紅色 9, 10, J, Q, K = 10
						// 紅色 2~8 分數與牌面數字一樣
	}
}