package sara.basic;

public class Issue6 {
	public static void main(String[] args) {
		boolean bay1 = Math.random() > 0.5;
		boolean bay2 = Math.random() > 0.5;
		//分成兩個杯並賦予其值，true 表示筊的凸面；反之， false 表示筊的平面
		int sinBay = 0;
		//用於計算擲出聖筊的數量
		int noBay = 0;
		//用於計算擲出無筊的數量
		int noResult = 0;
		//用於計算沒連續擲出三個聖筊或無筊的數量，最大值為 100
		int baySum = 0;
		//用於計算擲筊次數
		String result;
		//用於印出擲筊結果

		while(noResult < 100 && sinBay < 3 && noBay < 3) {
		//當括號中的條件成立時，會持續執行大括號中的程式值到括號中的條件不成立為止
			if(bay1 && bay2) {
			//如果 `bay1` 與 `bay2` 皆為凸面
				noBay++;
				//無筊次數 +1
				noResult++;
				//無結論次數 +1
				baySum++;
				//擲筊次數 +1
				sinBay = 0;
				//聖筊次數歸零
			}else if(!bay1 && !bay2) {
			//或是如果 `bay1` 與 `bay2` 皆為平面
				noResult++;
				//無結論次數 +1
				baySum++;
				//擲筊次數 +1
				noBay = 0;
				//無筊次數歸零
				sinBay = 0;
				//聖筊次數歸零
			}else  {
			//剩餘的其他結果
				sinBay++;
				//聖筊次數 +1
				noResult++;
				//無結論次數 +1
				baySum++;
				//擲筊次數 +1
				noBay = 0;
				//無筊次數歸零
			}
		}
		if(noBay >= 3) {
		//如果連續 + 了三次無筊
			result = "無筊";
			//result 會被賦予「無筊」這個字串
		}else if(sinBay >= 3) {
		//或是如果連續 + 了三次聖筊
			result = "聖筊";
			//result 會被賦予「聖筊」這個字串
		}else {
		//剩餘的其他結果
			result = "沒結論";
			//result 會被賦予「沒結論」這個字串
		}
		System.out.println("擲筊結果：" + " " + result + " " + "==>" + " " + "擲筊次數：" + " " + baySum);
	}
} 