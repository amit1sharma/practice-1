package in.amt.practice.arrays;

/**
 * Created by amit.sharma5 on 14/11/18.
 */
public class SegregateOneZero {
    void segregate(int[] arr){
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==1){
                count++;
            }
        }
        for(int i=0;i<arr.length;i++){
            /**
             * reverse if condition if want 0 to preceed 1
             */
            if(i<count) {
                arr[i] = 1;
            }else{
                arr[i]=0;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        SegregateOneZero segregate = new SegregateOneZero();
        segregate.segregate(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
