package sara.basic;

public class Issue6 {
	public static void main(String[] args) {
		//分成兩個杯並賦予其值，true 表示筊的凸面；反之， false 表示筊的平面
		boolean bay1 = Math.random() > 0.5;
		boolean bay2 = Math.random() > 0.5;
		int sinBaySum = 0; //用於計算擲出聖筊是否連續三次
		int noBaySum = 0;  //用於計算擲出無筊是否連續三次
		int noResult = 0;  //用於計算沒連續擲出三個聖筊或無筊的數量，最大值為 100
		int baySum = 0;    //用於計算總擲筊次數
		String result;
		
		//當 noResult<100、sinBaySum<3、noBaySum<3，任一條件不符合時，就會停止迴圈
		while(noResult < 100 && sinBaySum < 3 && noBaySum < 3) {
			baySum++;
			noResult++;
			if(bay1 && bay2) {  //當兩個筊都是凸面時，就執行以下內容
				noBaySum++;  //無筊連續次數 +1
				sinBaySum = 0;  //不是聖筊，所以歸零
			}else if(!bay1 && !bay2) {  //當兩個筊都是平面，就執行以下內容
				noBaySum = 0;  //不是無筊，所以歸零
				sinBaySum = 0; //不是聖筊，所以歸零
			}else {  //當兩個筊為一凸一平，就執行以下內容
				sinBaySum++;  //聖筊連續次數 +1
				noBaySum = 0; //不是無筊，所以歸零
			}
			bay1 = Math.random() > 0.5; //擲新的筊
			bay2 = Math.random() > 0.5; //擲新的筊
		}
		 if(noBaySum == 3) {
			 result = "無筊";
		}else if(sinBaySum == 3) {
			result = "聖筊";
		}else {
			result = "沒結論";
		}
		System.out.println("擲筊結果：" + " " + result + " " + "==>" + " " + "擲筊次數：" + " " + baySum);
	}
} 