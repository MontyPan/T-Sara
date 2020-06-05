package sara.basic;

public class Issue6 {
	public static void main(String[] args) {
		boolean bay1 = Math.random() > 0.5;
		boolean bay2 = Math.random() > 0.5;
		String result = null;

		if(bay1 == true && bay2 == true) {
			result = "無筊";
		}		
		if(bay1 == false && bay2 == false) {
			result = "笑筊";
		}
		if(bay1 == true && bay2 == false) {
			result = "聖筊";
		}
		if(bay1 == false && bay2 == true) {
			result = "聖筊";
		}
		System.out.println(result);
	}
} 