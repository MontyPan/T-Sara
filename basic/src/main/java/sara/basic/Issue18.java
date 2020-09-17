package sara.basic;

public class Issue18 {
	public static void main(String[] args) {
		int a1 = 1; // 首項 
		int d = 2; // 公差 = 2
		int n = 5; // 總項數 = 5
		int y = 0; // 項數計數器
		/*印出；1, 3, 5, 7, 9
		25*/
		System.out.print(a1);
		for (int i = 0; i < n-1; i++) {			
			y++;
			System.out.print("," + (a1 + (y * d)) );
		}
		System.out.println("\n" + (a1 + (a1 + (n-1) * d)) * n / 2);
	}
}
