package LeetCode75;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        int minimumLength = strs[0].length();

        if(strs == null || strs.length == 0) {
            return result.toString();
        }

        for(int i = 0; i < strs.length; i++) {
            minimumLength = Math.min(minimumLength, strs[i].length());
        }

        for(int i = 0; i < minimumLength; i++) {
            char current = strs[0].charAt(i);
            for(String str : strs) {
                if (str.charAt(i) != current) {
                    return result.toString();
                }
            }
            result.append(current);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        //String[] strs = {"flower","flow","flight"};
        String[] strs = {"","a"};
        String result = lcp.longestCommonPrefix(strs);
        System.out.println(result);
    }
}
