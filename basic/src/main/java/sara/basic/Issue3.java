package sara.basic;

public class Issue3 {
	public static void main(String[] args) {
		int score = 59;
		String result;
		if (score >= 60) {
			result = "及格";
		} else if (score >= 40) {
			result = "活當";
		} else {
			result = "死當";
		}
		System.out.println(score + " => " + result);
	}
}