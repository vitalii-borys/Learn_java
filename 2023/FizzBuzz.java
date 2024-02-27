import java.util.ArrayList;
import java.util.List;

class fizzBuzzSolution {
    public List<String> fizzBuzz(int n) {
        List<String> s = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            if ((i + 1) % 3 == 0 & (i + 1) % 5 == 0) {
                s.add(i, "FizzBuzz");
            } else if ((i + 1) % 3 == 0) {
                s.add(i, "Fizz");
            } else if ((i + 1) % 5 == 0) {
                s.add(i,"Buzz");
            } else {
                s.add(i, String.valueOf(i + 1));
            }
        }
        return s;
    }
    public static void main(String[] args) {
        fizzBuzzSolution s = new fizzBuzzSolution();
        int myNumber = 15;
        System.out.println(s.fizzBuzz(myNumber));
    }
}