package leetcode;

import java.util.ArrayList;

public class minStack155 {
	ArrayList<int[]> st;
	ArrayList<Integer> ans;
    public minStack155() {
        st = new ArrayList<int[]>();
        ans = new ArrayList<Integer>();
    }
    
    public void push(int val) {
    	ans.add(null);
        if(st.size() == 0){
            st.add(new int[]{val, val});
        }
        else{
            int min = st.get(st.size()-1)[1];
            if(min > val){
                min = val;
            }
            st.add(new int[]{val,min});
        }
    }
    
    public void pop() {
        st.remove(st.size()-1);
        ans.add(null);
    }
    
    public int top() {
    	ans.add(st.get(st.size()-1)[0]);
        return st.get(st.size()-1)[0];
    }
    
    public int getMin() {
    	ans.add(st.get(st.size()-1)[1]);
        return st.get(st.size()-1)[1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		minStack155 obj = new minStack155();
		obj.push(-2);
		obj.push(0);
		obj.push(-3);
		obj.getMin();
		obj.pop();
		obj.top();
		obj.getMin();
		System.out.println(obj.ans);

	}

}
