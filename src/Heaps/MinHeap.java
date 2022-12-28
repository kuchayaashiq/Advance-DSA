package Heaps;

import java.util.ArrayList;

public class MinHeap {
    ArrayList<Integer> data;

    public MinHeap() {
        data = new ArrayList<>();
    }

    // firstly add at the last of arraylist and the heapify
    // i.e rearrange the heap because the smallest element should be at root
    void add(int val){
        data.add(val);
        upHeapify(data.size()-1);
    }

    //remove
    int remove(){
        if(data.size() == 0){
            System.out.println("List is empty");
            return -1;
        }
        swap(0, data.size()-1);
        int rm = data.remove(data.size()-1);
        downHeapify(0);

        return rm;
    }

    private void downHeapify(int pi) {
        int lci = 2*pi+1;
        int rci = 2*pi+2;
        int mini = pi;
        if(lci < data.size() && data.get(lci) < data.get(mini)){
            mini = lci;
        }
        if(rci < data.size() && data.get(rci) < data.get(mini)){
            mini = rci;
        }
        if(mini !=  pi){
            swap(mini, pi);
            downHeapify(mini);
        }
    }

    private void upHeapify(int ci) {
        int pi = (ci-1)/2;
        if(data.get(pi) > data.get(ci)){
            swap(ci, pi);
            upHeapify(pi);
        }
    }

    private void swap(int ci, int pi) {
        int val1 = data.get(ci);
        int val2 = data.get(pi);

        data.set(pi, val1);
        data.set(ci, val2);
    }
    int peek(){
        if(data.size() == 0){
            System.out.println("List is empty");
            return -1;
        }
        return data.get(0);
    }
    int size(){
        return data.size();
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.add(1);
        minHeap.add(4);
        minHeap.add(5);
        minHeap.add(7);
        minHeap.add(8);
        minHeap.add(10);
        minHeap.add(6);
        minHeap.add(18);
        minHeap.add(14);
        minHeap.add(9);

        System.out.println(minHeap.data);
        minHeap.add(3);
        System.out.println(minHeap.data);

        // peek element
        System.out.println(minHeap.peek());
        //size of heap
        System.out.println(minHeap.size());

        // remove element
        System.out.println(minHeap.remove());
        System.out.println(minHeap.data);

        // heap sort
        while (minHeap.size() >0){
            int rm = minHeap.remove();
            System.out.print(rm+"  ");
        }

    }
}
