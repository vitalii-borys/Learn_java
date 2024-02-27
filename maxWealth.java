class maxWealth {
    public int maxWealthSolution(int[][] accounts) {
        int wealth = 0;
        int[] sums = new int[accounts.length];
        for (int a = 0; a < accounts.length; a++) {
            for (int b = 0; b < accounts[a].length; b++) {
                sums[a] = sums[a] + accounts[a][b];
            }
        }
        for (int i : sums) {
            if (i > wealth) {
                wealth = i;
            }
        }
        return wealth;
    }
    public static void main(String[] args) {
        maxWealth s = new maxWealth();
        int[][]accounts = {{2,8,7},{7,1,3},{1,9,5}};
        System.out.print(s.maxWealthSolution(accounts));
        System.out.print(" is the biggest wealth");
    }
}