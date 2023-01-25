import java.util.Scanner;

public class splitThousand {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		String ans  = splitsNumber(num1, num2);
		System.out.println(ans);
	}

	private static String splitsNumber(int num1, int num2) {
		// TODO Auto-generated method stub
		int ans = num1 / num2;
		String value = String.valueOf(ans);
		if(value.length()> 3) {
			StringBuilder sb = new StringBuilder();
			int count = 0;
			for(int i = value.length() -1; i >=0; i--) {
				char ch  = value.charAt(i);
				count++;
				sb.append(ch);
				if(count == 3) {
					sb.append(',');
					count = 0;
				}
			}
			
			return sb.reverse().toString();
		}
		else {
			
			return value;
		}
	}

}
