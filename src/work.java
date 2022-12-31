public class work {
    public static void main( String[] args){
        System.out.println("differenceMaxMin([10, 4, 1, 4, -10, -50, 32, 21]) ->" + differenceMaxMin(new int[]{10, 4, 1, 4, -10, -50, 32, 21}));
        System.out.println("differenceMaxMin([44, 32, 86, 19]) ->" + differenceMaxMin(new int[]{44, 32, 86, 19}));
    }
    public static int differenceMaxMin(int[] arr){
        int max = arr[0];
        int min= arr[0];
        for ( int ch : arr){
            if(ch > max)max=ch;
            if(ch < min)min=ch;
        }
        return max-min;
    }
}
