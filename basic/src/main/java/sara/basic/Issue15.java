package sara.basic;

public class Issue15 {
	public static void main(String[] args) {
		int a1 = 1; //首項
		int d = 2; //公差
		int n = 5; //項數
		int x = 0; //計算各項的值
		int y = 0; //項數計數器
		int sum = 0; //計算等差數列之和
		/*印出；1, 3, 5, 7, 9
		25*/
		while(y < 5) {
			if(y < 4) {
				x = a1 + (y * d);
				y++;
				System.out.print(x + "," + " ");
			}else {
				y++;
				x = x + d;
				System.out.println(x);
			}
		}
		sum = (a1 + (a1 + (n-1) * d)) * n / 2;
		System.out.println(sum);
	}
}
	