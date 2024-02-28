public class largestArr {
    public static void main(String[] args) {
        int[] myInts = {11, 22, 3, 44};
        int biggest = myInts[0];
        for (int i = 0; i < myInts.length; i++) {
            if (biggest < myInts[i]) {
                biggest = myInts[i];
            }
        }
        System.out.println(biggest);
    }
}
