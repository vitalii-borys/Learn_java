public class twoDarrayrotate {
    public static void main(String[] args) {
        int[][] myArray = {
            {1,2,3},
            {4,5,6}
        };
        for (int a=0; a<myArray.length; a++) {
            for (int b=0; b<myArray[a].length; b++) {
                System.out.print(myArray[a][b]);
            }
            System.out.println();
        }
    }    
}