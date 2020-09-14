package sara.basic;

public class Issue15 {
	public static void main(String[] args) {
		int a1 = 1; // 首項 = 1
		int d = 2; // 公差 = 2
		int n = 5; // 總項數 = 5
		int x = 0; // 各項的值
		int y = 0; // 項數計數器
		int sum = 0; // 計算總和
		/*
		 * 印出；1, 3, 5, 7, 9 
		 * 25
		 */
		while (y < n) {
			x = a1 + (y * d);
			if (y < n - 1) {
				System.out.print(x + ", ");
			} else if (y < n) {
				System.out.println(x);
				sum = (a1 + (a1 + (n - 1) * d)) * n / 2;
				System.out.println(sum);
			}
			y++;
		}
//		while (y < n-1) {
//			x = a1 + (y * d);
//			y++;
//			System.out.print(x + ",");
//		}
//		while (y < n) {
//			x = a1 + (y * d);
//			y++;
//			System.out.print(x);
//		}
//		sum = (a1 + (a1 + (n-1) * d)) * n / 2;
//		System.out.println(sum);
	}
}