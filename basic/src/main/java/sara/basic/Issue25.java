package sara.basic;

public class Issue25 {

	public static void main(String[] args) {
		int wtf = 5;
		part1(wtf);
		System.out.println("====================");
		part2(wtf);
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
			for (int i2 = n - 1; i2 > i; i2--) {
				System.out.print(" ");
			}
			for (int i2 = n - 1; i2 > i + 1; i2--) {
				System.out.print(" ");
			}
			for (int i2 = 0; i2 <= i; i2++) {
				if (i2 < 4) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}

	private static void part3(int n) {
		for (int i = 1; i < n; i++) {
			for (int i2 = n; i2 > i; i2--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
