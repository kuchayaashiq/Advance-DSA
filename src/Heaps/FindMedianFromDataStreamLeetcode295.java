package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FindMedianFromDataStreamLeetcode295 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MedianFinder medianFinder = new MedianFinder();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            if (s.equals("addNum"))
                medianFinder.addNum(sc.nextInt());
            else if (s.equals("findMedian"))
                System.out.println(medianFinder.findMedian());
        }
        sc.close();
    }

    static  class MedianFinder {
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;
        public MedianFinder() {
            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if(left.size() ==0 ||num <= left.peek()){
                left.add(num);

            }
            else {
                right.add(num);
            }
            int ls = left.size();
            int rs = right.size();
            if(ls-rs == 2){
                right.add(left.remove());
            }
            if(rs > ls){
                left.add(right.remove());
            }
        }

        public double findMedian() {
            if(left.size() == right.size()){
                return (left.peek()*1.0 + right.peek()*1.0)/2;
            }
            else
                return left.peek();
        }
    }
}
