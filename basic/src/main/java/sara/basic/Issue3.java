package sara.basic;

public class Issue3 {
	public static void main(String[] args) {
		int score = 59;
		String result;
		if (score >= 60) {
			result = "�ή�";
		} else if (score <= 59 && score > 39) {
			result = "����";
		} else {
			result = "����";
		}
		System.out.println(score + " => " + result);
	}
}