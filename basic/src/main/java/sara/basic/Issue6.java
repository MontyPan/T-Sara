package sara.basic;

public class Issue6 {
	public static void main(String[] args) {
		boolean bay1 = Math.random() > 0.5;
		boolean bay2 = Math.random() > 0.5;
		int sinBay = 0;
		int noBay = 0;
		int noResult = 0;
		int baySum = 0;
		String result;

		while(noResult < 100 && sinBay < 3 && noBay < 3) {
			if(bay1 && bay2) {
				noBay++;
				noResult++;
				sinBay = 0;
			}else if(!bay1 && !bay2) {
				noResult++;
				noBay = 0;
				sinBay = 0;
			}else  {
				sinBay++;
				noResult++;
				noBay = 0;
			}
		}
		if(noBay >= 3) {
			result = "無筊";
			baySum = noBay;
		}else if(sinBay >= 3) {
			result = "聖筊";
			baySum = sinBay;
		}else {
			result = "沒結論";
			baySum = noResult;
		}
		System.out.println("擲筊結果：" + " " + result + " " + "==>" + " " + "擲筊次數：" + " " + baySum);
	}
} 