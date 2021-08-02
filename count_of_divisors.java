/*Count of divisors
Problem Description

Given an array of integers A, find and return the count of divisors of each element of the array.

NOTE: Order of the resultant array should be same as the input array.



Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 106



Input Format
The only argument given is the integer array A.



Output Format
Return the count of divisors of each element of the array in the form of an array.



Example Input
Input 1:

 A = [2, 3, 4, 5]
Input 2:

 A = [8, 9, 10]


Example Output
Output 1:

 [2, 2, 3, 2]
Output 1:

 [4, 3, 4]


Example Explanation
Explanation 1:

 The number of divisors of 2 : [1, 2], 3 : [1, 3], 4 : [1, 2, 4], 5 : [1, 5]
 So the count will be [2, 2, 3, 2].
Explanation 2:

 The number of divisors of 8 : [1, 2, 4, 8], 9 : [1, 3, 9], 10 : [1, 2, 5, 10]
 So the count will be [4, 3, 4].*/
//My process
//Submit and see
public class Solution {
    public int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int m=A[0].length,n=A.length,i,j,a=1000000007;
         for(i=0;i<n;i++)
         {
             for(j=1;j<m;j++)
             {
                 A[i][j]=(A[i][j]%a+A[i][j-1]%a)%a;
             }
         }
         int l=B.length;
         int arr[]=new int[l];
         for(i=0;i<l;i++)
         {
             arr[i]=0;
            for(j=B[i]-1;j<D[i];j++)
            {
                if(C[i]>1)
                    arr[i]=(arr[i]%a+(A[j][E[i]-1]%a-A[j][C[i]-2]%a)%a)%a;
                else
                arr[i]=(arr[i]%a+A[j][E[i]-1]%a)%a;
            }
         }
        return arr;
    }
}
/*Their approach
//LOGIC:
Using seive, we can store the smallest prime factor for all the numbers upto the maximum no (here it is 106).
This above information helps in determining the prime factors for any no in O(log n) time-complexity for each query.

We take each no in the input array. Then prime factorise it to count the powers of each prime factors in a number.

N = (p1n1) * (p2n2) * (p3n3).

Here, N can be represented as p1 prime raised to the power n1 muliply p2 prime raised to n2 multiply p3 raised to n3.

So, total factors of N will be (n1 + 1) * (n2 + 1) * (n3 + 1).

For eg: 18 = (21) * (32).

So, total factors = 2*3 = 6.
public class Solution {
    
    //S[x] = smallest prime factor of x
    int S[], SZ, NP = 1001001;
    
    void sieve() {
        int n = NP;
        S = new int[n];
        for(int i = 1; i < n; i++) 
            S[i] = i;
        for(int i = 2; i * i <= n; i++) 
        {
            if( S[i] != i )
                continue;
            for(int j = i * i; j < n; j += i) 
            {
                if(S[j] == j)
                    S[j] = i;
            }
        }
    }
    
    int countDivisors(int x) {
        int ans = 1;
        while(S[x] > 1) {
            int cnt = 1, u = S[x];
            while(S[x] == u) {
                cnt++;
                x /= u;
            }
            ans *= cnt;
        }
        return ans;    
    }
    
    public int[] solve(int[] a) {
        sieve();
        int n = a.length;
        int ans[] = new int[n];
        for(int i = 0; i < n; i++)
            ans[i] = countDivisors(a[i]);
        return ans;
    }
}*/
