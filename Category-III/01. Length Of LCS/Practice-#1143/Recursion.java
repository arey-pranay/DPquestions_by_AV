class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return func(text1, text2, 0, 0, 0);
    }
    // function returns the number of matching characters till ith index of text1 and jth index of text2
    // so if the character matches, I increase count and call for i+1, j+1
    // otherwise I keep i constant and increment j and also keep j constant and increment i
    public int func(String text1, String text2, int i, int j, int count){
        if(i==text1.length() || j==text2.length()) return count;
        if(text1.charAt(i) == text2.charAt(j)) return func(text1, text2, i+1, j+1, count+1);
        return Math.max(func(text1, text2, i+1, j, count), func(text1, text2, i, j+1, count));
    }
}
