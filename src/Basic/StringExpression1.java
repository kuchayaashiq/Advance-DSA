import java.util.HashMap;

public class StringExpression1 {
	public static void main(String[] args) {
        boolean sign = true;
        int flag = 0;
        boolean B = true;
        int sum = 0, prev = 0;
        int a = 0, b = 0;
        int ans = 0;
        StringBuilder sb = new StringBuilder();
        HashMap<String,Integer> hm = new HashMap<>();
        String s = "nineninenineplusone";
        hm.put("zero",0);
        hm.put("one",1);
        hm.put("two",2);
        hm.put("three",3);
        hm.put("four",4);
        hm.put("five",5);
        hm.put("six",6);
        hm.put("seven",7);
        hm.put("eight",8);
        hm.put("nine",9);
        int n = s.length();
        for(int i = 0 ; i < n ; i++){
            prev = sum;
 
//            if its a '+' sign
            if(sb.toString().equals("plus")){
                flag = 0;
                sb.setLength(0);
            }
//             if its '-' sign
            if(sb.toString().equals("minus")){
                flag = 1;
                sb.setLength(0);
            }
            sb.append(s.substring(i,i+1));
 
 
            if(hm.containsKey(sb.toString())){
                if(B){
                    a = a*10 + hm.get(sb.toString());
                    sb.setLength(0);
                    if (i!=n-1 && (s.charAt(i + 1) == 'p' || s.charAt(i + 1) == 'm')) {
                        B = false;
                    }
                }
                else {
                    b = b*10 + hm.get(sb.toString());
                    sb.setLength(0);
                    if (i != n-1 && (s.charAt(i + 1) == 'p' || s.charAt(i + 1) == 'm')) {
                        B = true;
                        sum++;
                    }
                }
            }
            if(sum>prev){
                if(flag==0){
                    ans = a + b;
                    a = 0;b = 0;
                }
                else {
                    ans = a - b;
                    a = 0;b = 0;
                }
            }
            if(i==n-1 && b != 0){
                if(flag==0){
                    ans += b;
                }
                else{
                    ans -= b;
                }
            }
            if(i==n-1 && a != 0){
                if(flag==0){
                    ans += a;
                }
                else{
                    ans -= a;
                }
            }
        }
//        System.out.println(ans);
        if(ans<0){
            sign = false;
        }
        ans = Math.abs(ans);
        String answer = "";
        String S = String.valueOf(ans);
        int m = S.length();
        for(int i = 0 ; i < m ; i++){
            for(String t : hm.keySet()){
                if(hm.get(t) == Integer.parseInt(S.substring(i,i+1))){
                    answer = answer+t;
                }
            }
        }
        if(sign){
            System.out.println(answer);
        }
        else {
            System.out.println("negative"+ answer);
        }
	}
}
