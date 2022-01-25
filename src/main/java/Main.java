public class Main {

    public static void main(String[] args) {

        int arr[] = {1, 45, 782, 23, 67, 99};
        Main main = new Main();
        main.radix(arr);
        System.out.println(main.radix(arr));
    }

    public  int findMax(int arr[]){
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i]>max)
                max=arr[i];
        }
        return max;
    }

    static void countingSort(int a[], int place){
        int[] output = new int[a.length];
        int[] count = new int[10];
        for(int i = 0; i<a.length; i++){
            count[(a[i]/place)%10]++;
        }
        for(int i=1; i<10; i++){
            count[i] += count[i-1];
        }

        for(int i = a.length-1;i>=0;i--){
            output[count[(a[i]/place)%10]-1]=a[i];
            count[(a[i]/place)%10]--;
        }

        for(int j = 0; j<a.length; j++){
            a[j] = output[j];
        }
    }

    public  long radix(int[] a){
        long start = System.currentTimeMillis();
        // System.out.println(start);
        int max = findMax(a);
        for(int place = 1; max/place>0;place*=10){
            countingSort(a,place);
        }
        long end = System.currentTimeMillis();
        //  System.out.println(end);
        long executeTime = end - start;
        //     System.out.println("Execute time " + executeTime);
//        for (int i = 0; i<a.length; i++){
//            System.out.println(a[i]);
//        }
        return executeTime;
    }


}