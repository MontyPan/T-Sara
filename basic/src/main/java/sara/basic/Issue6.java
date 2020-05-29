package sara.basic;

public class Issue6 {
	public static void main(String[] args) {
		int t = 0;
		int sinbay = 0;
		int gaybay = 0;
		String result1, result2;
		
		while(t < 100 && sinbay < 3 && gaybay < 3) {
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
		System.out.println("聖杯：" + sinbay +" "+ "無筊：" + gaybay + " " + "擲筊次數：" + t); }
}