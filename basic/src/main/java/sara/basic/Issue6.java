package sara.basic;

public class Issue6 {
	public static void main(String[] args) {
		int t = 0;
		int sinbay = 0;
		int gaybay = 0;
		int noend = 0;
		String result1, result2;
		
		while(noend < 100 && sinbay < 3 && gaybay < 3) {
			if(Math.random() > 0.5) {
				result1 = "陽"; 
				sinbay++;
				System.out.println(sinbay + result1);
			}else {
				result2 = "陰";
				gaybay++;
				System.out.println(gaybay + result2);
				
				if (sinbay < 2 && gaybay < 2) {
					noend++;
				}
			}
		}
		t = sinbay + gaybay;
		System.out.println("聖杯：" + sinbay +" "+ "無筊：" + gaybay + " " + "沒結論：" + " " + noend + " " + "擲筊次數：" + t); 
		}
}