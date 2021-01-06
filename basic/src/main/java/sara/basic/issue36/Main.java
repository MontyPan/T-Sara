package sara.basic.issue36;

public class Main {

	public static void main(String[] args) {
		SaraStack stack = new SaraStack();
		stack.push("紅鯉魚家有頭小綠驢叫李屢屢");
        stack.push("綠鯉魚家有頭小紅驢叫呂里里");
        System.out.println(stack.pop());    //印出「綠鯉魚家有頭小紅驢叫呂里里」
        stack.push("紅鯉魚說他家的李屢屢比綠鯉魚家的呂里里綠");
        stack.push("綠鯉魚說他家的呂里里比紅鯉魚家的李屢屢紅");
        System.out.println(stack.pop());    //印出「綠鯉魚說他家的呂里里比紅鯉魚家的李屢屢紅」
        System.out.println(stack.pop());    //印出「紅鯉魚說他家的李屢屢比綠鯉魚家的呂里里綠」
        stack.push("不知是綠鯉魚比紅鯉魚的驢紅");
        System.out.println(stack.pop());    //印出「不知是綠鯉魚比紅鯉魚的驢紅」
        stack.push("還是紅鯉魚比綠鯉魚的驢綠");
        System.out.println(stack.pop());    //印出「還是紅鯉魚比綠鯉魚的驢綠」
        System.out.println(stack.pop());    //印出「紅鯉魚家有頭小綠驢叫李屢屢」
        System.out.println(stack.pop());    //印出「It's empty 此罐已空」
	}
}
