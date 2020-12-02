package sara.basic;

public class Issue25 {

	public static void main(String[] args) {
		int wtf = 5;
		part1(wtf);
		System.out.println("====================");
		part2(wtf);
		System.out.println("====================");
		part3(wtf);
		System.out.println("====================");
		part4(wtf);
		System.out.println("====================");
	}

	private static void part1(int n) {
		for (int i = 0; i < n; i++) {
			for (int i2 = 0; i2 <= i; i2++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 1; i < n; i++) {
			for (int i2 = n; i2 > i; i2--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void part2(int n) {
		for (int i = 0; i < n; i++) {
			for (int i2 = 0; i2 <= i; i2++) {
				System.out.print("*");
			}
			for (int i2 = 1; i2 <= (2 * n - (2 * i + 2)); i2++) {
				System.out.print(" ");
			}
			for (int i2 = 0; i2 <= i; i2++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void part3(int n) {
		for (int i = 1; i <= n; i++) {
			for (int i2 = n; i2 > i; i2--) {
				System.out.print(" ");
			}
			for (int i2 = 0; i2 < (i * 2) - 1; i2++) {
				int temp = i2 % (i * 2);
				if (i == 1) {
					System.out.print(temp + 1);
				} else if (i == 2) {
					System.out.print(temp + 2);
				} else if (i == 3) {
					System.out.print(temp + 5);
				} else if (i == 4) {
					System.out.print(temp);
				} else if (i == 5) {
					if (i2 <= 2) {
						System.out.print(temp + 7);
					} else if (i2 >= 3) {
						System.out.print(temp - 3);
					}
				}
			}
			System.out.println();
		}
	}

	private static void part4(int n) {
		for (int i = 0; i < n; i++) {
			for (int i2 = n; i2 > i + 1; i2--) {
				System.out.print(" ");
			}
			for (int i2 = n; i2 > i; i2--) {
				System.out.print("*");
			}
			for (int i2 = 1; i2 < (i * 2); i2++) {
				System.out.print(" ");
			}
			for (int i2 = 0; i2 <= i; i2++) {
				if (i != 0) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		for (int i = 1; i < n; i++) {
			for (int i2 = 1; i2 <= i; i2++) {
				System.out.print(" ");
			}
			for (int i2 = 0; i2 <= i; i2++) {
				System.out.print("*");
			}
			for (int i2 = 0; i2 <= n - (i * 2) + 1; i2++) {
				System.out.print(" ");
			}
			for (int i2 = 0; i2 < (n - i); i2++) {
				if ((n - i) == 1) {
					System.out.print("");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}
