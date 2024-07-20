package DynamicProgramming.longestcommonsubsequence;

public class LongestCommonSubsequenceRecursive {
    public Integer findLCS(String X, String Y, Integer xlen, Integer ylen) {
        if (xlen == 0 || ylen == 0) {
            return 0;
        }

        if (X.charAt(xlen-1) == Y.charAt(ylen-1)) {
            return 1+findLCS(X,Y,xlen-1,ylen-1);
        } else {
            return Math.max(findLCS(X,Y,xlen-1,ylen), findLCS(X,Y,xlen,ylen-1));
        }
    }

    public static void main(String[] args) {
        String string1 = "abcdgh";
        String string2 = "abedfhr";

        LongestCommonSubsequenceRecursive recursive = new LongestCommonSubsequenceRecursive();
        Integer lcsCount = recursive.findLCS(string1, string2, string1.length(), string2.length());
        System.out.println("Length: " + lcsCount);
    }
}
