public class SequencePatternMatching {

    // Function to check if pattern is a subsequence of text
    public static boolean isSubsequence(String text, String pattern) {
        int m = text.length();
        int n = pattern.length();
        
        int i = 0, j = 0;
        
        // Traverse the text and pattern
        while (i < m && j < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                j++; // Move the pattern pointer if characters match
            }
            i++; // Always move the text pointer
        }
        
        // If we have traversed all characters of pattern, it's a subsequence
        return j == n;
    }

    public static void main(String[] args) {
        String text = "abcpqr";
        String pattern = "abc";
        
        if (isSubsequence(text, pattern)) {
            System.out.println("Pattern is a subsequence of the text.");
        } else {
            System.out.println("Pattern is not a subsequence of the text.");
        }
    }
}
