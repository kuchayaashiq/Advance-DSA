package Backtracking.PermetationCombination;

public class CombinationOneCoin {
    public static void main(String[] args) {
        int[] arr ={2,3,5,6,7};
        combination_oneCoin(arr, 0, 12, 0, "");
        System.out.println();
        combination_ManyCoins(arr, 0, 12, 0, "");
        System.out.println();
        combination(arr, 0, 12, 0, "");
    }
    public static void combination_oneCoin(int[] arr, int idx, int tar, int csum, String asf){
        if(csum>tar){
            return;
        }
        if(idx == arr.length){
            if(csum==tar){
                System.out.println(asf);
            }
            return;
        }

        // include
        combination_oneCoin(arr, idx+1, tar, csum+arr[idx], asf+arr[idx]+",");

        // not include
        combination_oneCoin(arr, idx+1, tar, csum, asf);
    }

    public static void combination_ManyCoins(int[] arr, int idx, int tar, int csum, String asf){
        if(csum>tar){
            return;
        }
        if(idx == arr.length){
            if(csum==tar){
                System.out.println(asf);
            }
            return;
        }

        // include (I can include the same coin again, so next call is with the same idx)
        combination_ManyCoins(arr, idx, tar, csum+arr[idx], asf+arr[idx]+",");

        // not include
        combination_ManyCoins(arr, idx+1, tar, csum, asf);
    }

    public static void combination(int[] arr, int idx, int tar, int csum, String asf){
        if(csum>tar){
            return;
        }
            if(csum==tar){
                System.out.println(asf);
            }


        for (int j = 0; j < arr.length; j++) {
            combination(arr, j, tar, csum+arr[j], asf+arr[j]+",");
        }

    }
}
