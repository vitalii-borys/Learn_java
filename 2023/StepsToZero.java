class Solution {
    public int numberOfSteps(int num) {
        int count = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num = num / 2;
                count++;
            } else {
                num = num - 1;
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int myNumber = 123;
        System.out.println(s.numberOfSteps(myNumber));
    }
}