package sara.basic.pickred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Issue28 {

	static String[][] players;
	static String[] showedPoker;
	static String[] shuffledPoker;
	static int[] score;
	static int diffScore;
	static boolean isMatch;

	public static void main(String[] args) {
// 輸入玩家人數
		int playersSum = getPlayersSum();

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
		shuffledPoker = new String[52];
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
		players = dealCardToEachPlayer(playersSum, shuffledPoker);

// 每個玩家擁有的手牌
		for (String[] player : players) {
			for (String card : player) {
				System.out.print(card + ",");
			}
			System.out.println();
		}

// 把發出去的牌的空間與元素移除
		shuffledPoker = removeEmptyElement(shuffledPoker);

// 翻出剩餘的牌前四張於桌面
// 海底翻開的牌
		showedPoker = new String[4];
		for (int i = 0; i < 4; i++) {
			showedPoker[i] = shuffledPoker[i];
			shuffledPoker[i] = "0";
		}
		System.out.println("海底的牌：" + Arrays.toString(showedPoker));

// 把翻出的牌的空間與元素移除
		shuffledPoker = removeEmptyElement(shuffledPoker);
		System.out.println("洗牌完成，開始遊戲\n蓋牌：" + Arrays.toString(shuffledPoker));

// 遊戲開始：輪流打出手牌
// 計分板
		score = new int[players.length];

		gamePlaying();
		System.out.println("遊戲結束");
		int total = 0;
		for (int i = 0; i < players.length; i++) {
			System.out.println("玩家 " + i + " 剩餘手牌：" + players[i].length + "、分數為：" + score[i]);
			total += score[i];
		}
		System.out.println("總分：" + total);
		int winner = score[0];
		int winPlayer = 0;
		for (int i = 1; i < score.length; i++) {
			if (score[i] > winner) {
				winner = score[i];
				winPlayer = i;
			}
		}
		System.out.println("玩家" + winPlayer + "贏了，分數為：" + winner);
	}

	public static void gamePlaying() {
		while (showedPoker.length > 0 && shuffledPoker.length > 0) {
			for (int i = 0; i < players.length; i++) {
				for (int i2 = 0; i2 < players[i].length; i2++) {
					isMatch = false;
					for (int i3 = 0; i3 < showedPoker.length; i3++) {
						isMatch = false;
						isMatch = checkPairAndPoint(players[i][i2], showedPoker[i3], i);
						if (isMatch) {
							players[i][i2] = "0";
							showedPoker[i3] = "0";
							players[i] = removeEmptyElement(players[i]);
							showedPoker = removeEmptyElement(showedPoker);
// 配對成功，翻一張牌比對海底
							pickAndMatchCard(i);
							break;
						}
					}
					if (isMatch) {
						break;
					}
				}
				if (!isMatch) {
					moveCardToShowed(i);
					pickAndMatchCard(i);
				} else if (showedPoker.length == 0 && shuffledPoker.length > 0) {
					addCardToShowed();
				}
			}
		}
	}

	public static void addCardToShowed() {
		showedPoker = addElement(showedPoker, shuffledPoker[0]);
		shuffledPoker[0] = "0";
		shuffledPoker = removeEmptyElement(shuffledPoker);
	}

	public static void moveCardToShowed(int player) {
		if (players[player].length > 0) {
			showedPoker = addElement(showedPoker, players[player][0]);
			players[player][0] = "0";
			players[player] = removeEmptyElement(players[player]);
		}
	}

	public static void pickAndMatchCard(int player) {
		if (shuffledPoker.length > 0) {
// 翻牌堆第一張牌跟海底比對
			boolean isSecondMatch = false;
			for (int i = 0; i < showedPoker.length; i++) {
				isSecondMatch = checkPairAndPoint(shuffledPoker[0], showedPoker[i], player);
				if (isSecondMatch) {
					shuffledPoker[0] = "0";
					showedPoker[i] = "0";
					shuffledPoker = removeEmptyElement(shuffledPoker);
					showedPoker = removeEmptyElement(showedPoker);
					break;
				}
			}
			if (!isSecondMatch) {
				showedPoker = addElement(showedPoker, shuffledPoker[0]);
				shuffledPoker[0] = "0";
				shuffledPoker = removeEmptyElement(shuffledPoker);
			}
		}
	}

	public static boolean checkPairAndPoint(String cardOne, String cardTwo, int player) {
		int numberCardOne = Integer.parseInt(cardOne.substring(1).trim());
		int numberCardTwo = Integer.parseInt(cardTwo.substring(1).trim());

		if ((numberCardOne + numberCardTwo) == 10) {
			countScore(cardOne, cardTwo, player);
			return true;
		} else if (numberCardOne > 9 && numberCardTwo > 9) {
			if (numberCardOne == numberCardTwo) {
				countScore(cardOne, cardTwo, player);
				return true;
			}
		}
		return false;
	}

	public static int getPlayersSum() {
		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入遊戲人數：2~4");
		int playersSum = sc.nextInt();
		while (playersSum <= 1 || playersSum >= 5) {
			System.out.println("請重新輸入人數");
			playersSum = sc.nextInt();
		}
		return playersSum;
	}

	public static String[][] dealCardToEachPlayer(int playersSum, String[] shuffledPoker) {
		if (playersSum == 2) {
			System.out.println("玩家共兩位");
			players = new String[2][12];
		} else if (playersSum == 3) {
			System.out.println("玩家共三位");
			players = new String[3][8];
		} else if (playersSum == 4) {
			System.out.println("玩家共四位");
			players = new String[4][6];
		}
		for (int i = 0; i < playersSum; i++) {
			for (int i2 = 0; i2 < players[0].length; i2++) {
				players[i][i2] = shuffledPoker[i2 + (i * players[0].length)];
				shuffledPoker[i2 + (i * players[0].length)] = "0";
			}
		}

		return players;
	}

	public static String[] removeEmptyElement(String[] pokerList) {
		List<String> tempRemoveList = new ArrayList<String>(Arrays.asList(pokerList));
		for (int i = 0; i < tempRemoveList.size(); i++) {
			tempRemoveList.remove("0");
		}
		pokerList = tempRemoveList.toArray(new String[tempRemoveList.size()]);

		return pokerList;
	}

	public static String[] addElement(String[] pokerList, String elm) {
		List<String> tempAddList = new ArrayList<String>(Arrays.asList(pokerList));
		tempAddList.add(elm);
		pokerList = tempAddList.toArray(new String[tempAddList.size()]);

		return pokerList;
	}

	public static void countScore(String countCardOne, String countCardTwo, int player) {
// 玩家比對成功的牌
// 海底比對成功的牌
		int scorePlayerCard = Integer.parseInt(countCardOne.substring(1).trim());
		int scoreShowedCard = Integer.parseInt(countCardTwo.substring(1).trim());
		String suitsFromPlayer = countCardOne.substring(0, 1);
		String suitsFromShowed = countCardTwo.substring(0, 1);

		if ((scorePlayerCard + scoreShowedCard) == 10) {
// 判斷幾分
			if (suitsFromPlayer.equals("♥") || suitsFromPlayer.equals("♦")) {
				if (scorePlayerCard == 1) {
					score[player] += 20;
				} else if (scorePlayerCard == 9) {
					score[player] += 10;
				} else {
					score[player] += scorePlayerCard;
				}
			}
			if (suitsFromShowed.equals("♥") || suitsFromShowed.equals("♦")) {
				if (scoreShowedCard == 1) {
					score[player] += 20;
				} else if (scoreShowedCard == 9) {
					score[player] += 10;
				} else {
					score[player] += scoreShowedCard;
				}
			}
			if (countCardOne.trim().equals("♠1") || countCardTwo.trim().equals("♠1")) {
				score[player] += 30;
			}
		} else if (scorePlayerCard > 9 && scoreShowedCard > 9) {
			if (scorePlayerCard == scoreShowedCard) {
				if (suitsFromPlayer.equals("♥") || suitsFromPlayer.equals("♦")) {
					score[player] += 10;
				}
				if (suitsFromShowed.equals("♥") || suitsFromShowed.equals("♦")) {
					score[player] += 10;
				}
			}
		}
	}
}