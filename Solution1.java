// Longest Common Subsequence

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int N = text1.length();
        int M = text2.length();
        int[][] lcs = new int[N + 1][M + 1];
        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= M; j++){
                if(i == 0 || j == 0){
                    lcs[i][j] = 0;
                }
                else if(text1.charAt(i-1) == text2.charAt(j-1)){
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                }
                else{
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }
        return lcs[N][M];
    }
}