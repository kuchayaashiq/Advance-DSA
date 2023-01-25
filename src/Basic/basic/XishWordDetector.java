package basic;

import java.util.Scanner;

public class XishWordDetector {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        String Xstring = sc.next();
    //CODE USING RECURSION
	System.out.print(wordFound(word,Xstring,0,0));

	// CODE WITHOUT USING RECURSION
//       int count =0;
//        for(int i=0;i<Xstring.length();i++){
//            for(int j =0;j<word.length();j++){
//                if(Xstring.charAt(i) == word.charAt(j)) {
//                    count++;
//                    break;
//                }
  
//          }
//        }
//        if(count == Xstring.length())
//            System.out.print(true);
//        else
//            System.out.print(false);
    }
     public static boolean wordFound(String str1, String str2, int i, int j){
	    if(i == str1.length()){
	      if(j == str2.length())
	        return true;
	      else 
 	       return false;
  	  }
 	   if(j == str2.length())
 	     return true;
 	   if(str1.charAt(i) == str2.charAt(j))
  	    return wordFound(str1,str2,i+1,j+1);
  	  else
   	   return wordFound(str1,str2,i+1,j);
     }
}
