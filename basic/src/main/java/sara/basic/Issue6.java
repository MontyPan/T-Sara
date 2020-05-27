package sara.basic;

public class Issue6 {
	public static void main(String[] args) {
		int t = 1;
		int sinbay = 1;
		int gaybay = 1;
		String result1, result2;
		while(t < 99) {
			if(Math.random() > 0.5) {
				result1 = "陽"; 
				sinbay++;
				t++;
				System.out.println(sinbay + result1);
			}else {
				result2 = "陰";
				gaybay++;
				t++;
				System.out.println(gaybay + result2);
			}
		}
		System.out.println("聖杯次數：" + sinbay +" "+ "無筊次數：" + gaybay);
	}
}