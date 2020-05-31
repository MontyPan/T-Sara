package sara.basic;

public class Issue6 {
	public static void main(String[] args) {
		int bay1, bay2;
		String result;
		
		if(Math.random() > 0.5) {
			bay1 = 20;
			System.out.println("陽");
		}else {
			bay1 = 10;
			System.out.println("陰");
		}		
			if(Math.random() > 0.5) {
				bay2 = 20;
				System.out.println("陽");
			}else {
				bay2 = 10;
				System.out.println("陰");
			}
				if(bay1 + bay2 >= 40) {
					result = "無筊";
				}else if (bay1 + bay2 >= 30) {
					result = "聖筊";
				}else {
					result = "笑筊";
				}
		System.out.println(result);
	}
}