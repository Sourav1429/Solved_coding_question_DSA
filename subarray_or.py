'''SUBARRAY OR
Problem Description

Given an array of integers A of size N.

Value of a subarray is defined as BITWISE OR of all elements in it.

Return the sum of Value of all subarrays of A % 109 + 7.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 108



Input Format
The first argument given is the integer array A.



Output Format
Return the sum of Value of all subarrays of A % 109 + 7.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [7, 8, 9, 10]


Example Output
Output 1:

 71
Output 2:

 110


Example Explanation
Explanation 1:

 Value([1]) = 1
 Value([1, 2]) = 3
 Value([1, 2, 3]) = 3
 Value([1, 2, 3, 4]) = 7
 Value([1, 2, 3, 4, 5]) = 7
 Value([2]) = 2
 Value([2, 3]) = 3
 Value([2, 3, 4]) = 7
 Value([2, 3, 4, 5]) = 7
 Value([3]) = 3
 Value([3, 4]) = 7
 Value([3, 4, 5]) = 7
 Value([4]) = 4
 Value([4, 5]) = 5
 Value([5]) = 5
 Sum of all these values = 71
Explanation 2:

 Sum of value of all subarray is 110.
'''
def cnt(n):
    return (n * (n + 1)) // 2

class Solution:
    # @param A : list of integers
    # @return an integer
    def solve(self, A):
        MOD = int(1e9 + 7)
        ans = 0
        n = len(A)
        for b in range(27):
            c = 0
            C = cnt(n)
            for i in range(n):
                if A[i] & 1:
                    C -= cnt(c)
                    c = 0
                else:
                    c += 1
                A[i] >>= 1
            C -= cnt(c)
            ans = (ans + (1 << b) * C) % MOD
        return ans
