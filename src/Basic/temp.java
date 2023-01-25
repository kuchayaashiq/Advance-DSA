import java.util.Scanner;
import java.util.Stack;

public class temp {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int heights[] = new int[n];
            for (int i = 0; i < n; i++) {
                heights[i] = sc.nextInt();
            }
            int maxArea =0;
            int ps[] = prevSmaller(heights);
            int ns[] = nextSmaller(heights);
            System.out.println();

            for (int i = 0; i < n; i++) {
                int curr =(ns[i]- ps[i] - 1)*heights[i];
                maxArea = Math.max(maxArea,curr);
            }
            System.out.println(maxArea);
        }

        private static int[] prevSmaller(int[] heights) {
            int ps[] = new int[heights.length];
            Stack<Integer> st =  new Stack<>();
            for (int i = 0; i <heights.length ; i++) {
                while (!st.empty() && heights[st.peek()] >= heights[i]) {
                    st.pop();
                }
                if(st.empty()) {
                    ps[i] =-1;
                }
                else
                    ps[i] =st.peek();
                st.push(i);
            }
            return ps;
        }

        private static int[]nextSmaller(int[] heights) {
            int ns[] = new int[heights.length];
            Stack<Integer> st =  new Stack<>();
            for (int i = heights.length-1; i >=0 ; i--) {
                while (!st.empty() && heights[st.peek()]>= heights[i]) {
                    st.pop();
                }
                if(st.empty()) {
                    ns[i] =heights.length;
                }
                else
                    ns[i] =st.peek();
                st.push(i);
            }
            return ns;
        }
    }
