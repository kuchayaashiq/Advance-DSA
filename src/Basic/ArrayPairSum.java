public class ArrayPairSum {
    public static void main(String args[]){
        int n =5;
        int a[] = new int[n];
        for (int i =0;i<n;i++){
            a[i] =i+1;
        }
        int count=0;
        for (int i =0;i<n;i++){
            for (int j =i+1;j<n;j++){
               if (a[i]+a[j]==n)
                   count=count+1;
            }
        }
        for (int i =0;i<n;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println(count);
    }
}
