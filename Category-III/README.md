#### 1. Length of Longest Common Subsequence

```
if(i==0||j==0)dp[i][j]=0
else if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])
```

#### 2. Length of Longest Common Substring

- Create a separate variable that will be returned at the end by the function, because we'll have to reset the dp[i][j] table as substring needs to be consecutive, unlike subsequence

int maxLength = 0;

```
if(i==0||j==0)dp[i][j]=0
else if(s1.charAt(i-1)==s2.charAt(j-1)) { dp[i][j] = dp[i-1][j-1] + 1; maxLength = Math.max(maxLength,dp[i][j]) }
else dp[i][j] = 0;
```

#### 3. Print the Longest Common Subsequence

- backtrack and append in the answer when matching character is found in string, otherwise just go to the bigger value from the dp table.

int i = m; int j=n; 
while(i > 0 && j > 0)
```
if(s1.charAt(i-1) == s2.charAt(j-1)) lcs.append(s1charAt(i-1)) i-- j--
else if(dp[i-1][j] > dp[j][i-1]) i--
else j--
```

#### 4. Length Of Shortest Common Supersequence

- you need minimum length string that can be used to construct A and B both
- return A.length() + B.length() - lcs(A,B)

#### 5. Minimum Insertion and Deletion in A to turn that into B
- For converting A to B, turn a to LCS, by deleting. => Deletions = A.length() - lcs(A,B)
- Then convert to obtained string to B, by inserting. => Insertions = B.length() - lcs(A,B)

#### 6. Longest Palindromic Subsequence

