class Solution {
   public int longestCommonSubsequence(String text1, String text2) {
      return func(text1, text2, 0, 0, new StringBuilder()).toString();

    }

    // Recursive function to find the LCS and build the result
    private StringBuilder func(String text1, String text2, int i, int j, StringBuilder currentLCS) {
        if (i == text1.length() || j == text2.length()) {
            return new StringBuilder(currentLCS);
        }
        
        if (text1.charAt(i) == text2.charAt(j)) {
            // Characters match, add to LCS and move both pointers
            currentLCS.append(text1.charAt(i));
            return func(text1, text2, i + 1, j + 1, currentLCS);
        } else {
            // Characters don't match, try both possibilities and choose the better result
            StringBuilder lcs1 = new StringBuilder(currentLCS);
            StringBuilder lcs2 = new StringBuilder(currentLCS);
            
            // Move only the first index
            StringBuilder result1 = func(text1, text2, i + 1, j, lcs1);
            // Move only the second index
            StringBuilder result2 = func(text1, text2, i, j + 1, lcs2);
            
            // Compare lengths of results to choose the longer one
            return result1.length() > result2.length() ? result1 : result2;
        }
    }
}
