public class twoDarrayrotate {
    public static void main(String[] args) {
        int[][] myArray = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}
        };
        for (int a=0; a<myArray[0].length; a++) {
            for (int b=0; b<myArray.length; b++) {
                System.out.print(myArray[b][a] + " ");
            }
            System.out.println();
        }
    }    
}