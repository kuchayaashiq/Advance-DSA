import java.util.HashMap;
import java.util.Scanner;

public class StringExpression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String exp  =sc.next();
		String ans = computeExpression(exp);
		System.out.println(ans);
		
	}

	private static String computeExpression(String exp) {
		HashMap<String, Character> hm = new HashMap<String, Character>();
		hm.put("minus",'-');
		hm.put( "plus",'+');
		hm.put("zero",'0');
		hm.put("one",'1');
		hm.put("two",'2');
		hm.put("three",'3');
		hm.put("four",'4');
		hm.put("five",'5');
		hm.put("six",'6');
		hm.put("seven",'7');
		hm.put("eight",'8');
		hm.put("nine",'9');
		
		StringBuilder sb  =  new StringBuilder();
		StringBuilder numeric  =  new StringBuilder();
		for(int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			sb.append(ch);
			if(hm.containsKey(sb.toString())) {
				numeric.append(hm.get(sb.toString()));
				sb.setLength(0);
			}
		}
		int num1 = 0, num2 = 0;
		int sum = 0;
		int sign = -1;

		for (int i = 0; i < numeric.length(); i++) {
			char ch = numeric.charAt(i);
			if((ch != '+'&& ch != '-') && (sign == -1)) {
				num1 *= 10;
				num1 += ch - '0';
				
			}
			if((ch != '+'|| ch != '-') && (num1 == 0)) {
				num2 *= 10;
				num2 += ch - '0';
				
			}
			if(ch == '+' ) {
				if(num1 == 0 || num2 == 0) {
					sign  = 1;
				}
				else {
					sum  =  num1 + num2;
					num1 = sum;
					num2 = 0;
					
				}
				
			}
			if(ch == '-' ) {
				if(num1 == 0 || num2 == 0) {
					sign  = -1;
				}
				else {
					sum  =  num1 - num2;
					num1 = sum;
					num2 = 0;
					
				}
				
			}
			
			else {
				
			}
			
			
		}
		System.out.println(sum);
		return numeric.toString();
	}

}
