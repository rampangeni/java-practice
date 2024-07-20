package DynamicProgramming.longestcommonsubsequence;

public class LongestCommonSubsequenceBottomUp {
    public Integer findLCS(String X, String Y, Integer xlen, Integer ylen) {
        int[][] memoization = new int[xlen+1][ylen+1];

        for(int i=1; i <= xlen; i++) {
            for(int j=1; j <= ylen; j++) {
                if (i == 0 || j == 0) {
                    memoization[i][j] = 0;
                } else if (X.charAt(i-1) == Y.charAt(j-1)) {
                    memoization[i][j] = 1 + memoization[i-1][j-1];
                } else {
                    memoization[i][j] = Math.max(memoization[i][j-1], memoization[i-1][j]);
                }
            }
        }

        return memoization[xlen][ylen];
    }

    public static void main(String[] args) {
        String string1 = "abcdgh";
        String string2 = "abedfhr";

        LongestCommonSubsequenceBottomUp bottomUp = new LongestCommonSubsequenceBottomUp();
        Integer lcsCount = bottomUp.findLCS(string1, string2, string1.length(), string2.length());
        System.out.println("Length: " + lcsCount);
    }
}
