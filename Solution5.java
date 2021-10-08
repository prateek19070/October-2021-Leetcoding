// Climbing Stairs

class Solution {
    public int climbStairs(int n) {
        return fib(n + 1);
    }
    public int fib(int s){
        int[] fib = new int[s + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= s; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[s];
    }
}