package sara.basic;

public class Issue6 {
	public static void main(String[] args) {
		boolean bay1 = Math.random() > 0.5;
		boolean bay2 = Math.random() > 0.5;
		String result;

		if(bay1 && bay2) {
			result = "無筊";
		}else if(bay1 != true && bay2 != true) {
			result = "笑筊";
		}else  {
			result = "聖筊";
		}
		System.out.println(result);
	}
} 