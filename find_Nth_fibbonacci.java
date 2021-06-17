/*Problem Description

Given an integer A you need to find the Ath fibonacci number modulo 109 + 7.

The first fibonacci number F1 = 1

The first fibonacci number F2 = 1

The nth fibonacci number Fn = Fn-1 + Fn-2 (n > 2)



Problem Constraints
1 <= A <= 109.



Input Format
First argument is an integer A.



Output Format
Return a single integer denoting Ath fibonacci number modulo 109 + 7.



Example Input
Input 1:

 A = 4
Input 2:

 A = 3


Example Output
Output 1:

 3
Output 2:

 2


Example Explanation
Explanation 1:

 F3 = F2 + F1 = 1 + 1 = 2
 F4 = F3 + F2 = 2 + 1 = 3
Explanation 2:

 F3 = F2 + F1 = 1 + 1 = 2
*/
public class Solution {
    int mod = (int)(1e9) + 7;
    public int solve(int A) {
        long[][] f = {{1 , 1} , {1 , 0}};
        return (int)(power(f , A-1)[0][0] %mod);
    }public long[][] power(long[][] f , int n){
        if(n == 1) return f;
        long[][] new_f = (power(f , n/2));
        
        if(n%2 == 0) return mult(new_f , new_f);
        else return mult(f , mult(new_f , new_f));
    }public long[][] mult(long[][] A , long[][] B){
        long[][] res = new long[A.length][B[0].length];
        
        for(int i = 0 ; i < res.length ; i++){
            for(int j = 0 ; j < res[0].length ; j++){
                
                for(int k = 0 ; k < A[0].length ; k++){
                    res[i][j] =(res[i][j] + A[i][k] * B[k][j])%mod;
                }
            }
        }return res;
    }
}

