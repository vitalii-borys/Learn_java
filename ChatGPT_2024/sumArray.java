public class sumArray {
    public static void main(String[] args) {
        int[] myInts = {12,23,34};
        int sum = 0;
        for (int i = 0; i < myInts.length; i++) {
            sum = sum + myInts[i];
        }
        System.out.println("The sum is " + sum);
    }
}
