import java.util.Arrays;

class bubbleSort {
    public static void main(String[] args) {
        int[] myArray = {9,7,8,8,4,3,3,2,1,6};
        System.out.println("The initial array is " + Arrays.toString(myArray));
        for (int a = 0; a < myArray.length - 1; a++) {
            for (int i = 0; i < myArray.length - 1; i++) {
                if (myArray[i] > myArray[i + 1]) {
                    int c = myArray[i];
                    myArray[i] = myArray[i + 1];
                    myArray[i + 1] = c;
                }
            }
        }
        System.out.println("And here is same but sorted " + Arrays.toString(myArray));
    }
}