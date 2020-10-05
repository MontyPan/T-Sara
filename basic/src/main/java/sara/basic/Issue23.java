package sara.basic;

public class Issue23 {

	public static void main(String[] args) {
		int wtf = 5;
		part0(wtf);
		System.out.println("\n====================");
		part1(wtf);
		System.out.println("====================");
		part2(wtf);
		System.out.println("====================");
		part3(wtf);
		System.out.println("====================");
		part4(wtf);
		System.out.println("====================");		
	}
	
	private static void part0(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print("*");
		}
	}
	
	private static void part1(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println("*");
		}
	}
	
	private static void part2(int n) {
		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	private static void part3(int n) {
		for (int i = 0; i < n; i++) {
			for (int k = 0; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	private static void part4(int n) {
		for (int i = 0; i < n; i++) {
			for (int m = i; m < n-1; m++) {
				System.out.print("_");
			}
			for (int k = 0; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
