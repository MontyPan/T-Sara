package sara.basic;

public class Issue18 {
	public static void main(String[] args) {
			int a1 = 1; // 首項 
			int d = 2; // 公差 = 2
			int n = 5; // 總項數 = 5
			int x = 0; // 各項的值
			/*印出；1, 3, 5, 7, 9
			25*/
			for (int y = 0; y < n-1; y++) {
				x = a1 + (y * d);
				System.out.print(x + ",");
			}
			System.out.println(x + d);
			System.out.println((a1 + (a1 + (n-1) * d)) * n / 2);
		}
}
