package sara.basic;

public class Issue6 {
	public static void main(String[] args) {
		int t = 0;
		int sinbay = 0;
		int gaybay = 0;
		int chobay = 0;
		int bay1, bay2;
			
		while(sinbay < 3 && gaybay < 3 && chobay < 100) {
			if(Math.random() > 0.5) {
				bay1 = 10; 
				bay2 = 10;
				System.out.println("陽");
			}else {
				bay1 = 20;
				bay2 = 20;	
				System.out.println("陰");
			}
				if(bay1 + bay2 >= 40) {
					gaybay++;
					System.out.println("陰筊");
				} else if(bay1 + bay2 >= 30) {
					sinbay++;
					System.out.println("聖筊");
				} else {
					chobay++;
				} 
		t = sinbay + gaybay + chobay;
		System.out.println("聖筊：" + sinbay +" "+ "陰筊：" + gaybay + " " + "沒結論：" + " " + chobay + " " + "擲筊次數：" + t); 
		}
	}
}