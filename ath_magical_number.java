/*Ath Magical Number
Problem Description

Given three positive integers A, B and C.

Any positive integer is magical if it is divisible by either B or C.

Return the Ath magical number. Since the answer may be very large, return it modulo 109 + 7.



Problem Constraints
1 <= A <= 109

2 <= B, C <= 40000



Input Format
The first argument given is an integer A.

The second argument given is an integer B.

The third argument given is an integer C.



Output Format
Return the Ath magical number. Since the answer may be very large, return it modulo 109 + 7.



Example Input
Input 1:

 A = 1
 B = 2
 C = 3
Input 2:

 A = 4
 B = 2
 C = 3


Example Output
Output 1:

 2
Output 2:

 6


Example Explanation
Explanation 1:

 1st magical number is 2.
Explanation 2:

 First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.*/
public class Solution {
    public int min(int a,int b)
       { return (a>b)?b:a;}
    public int lcm(int a,int b)
    {
        int r;
        while(b!=0)
        {
            r=a%b;
            a=b;
            b=r;
        }
        return a;
    }
    public int solve(int A, int B, int C) {
        int m=1000000007;long a=(min(B,C)*(long)(A)),lo,hi,mid=1,ans,c=0;
        lo=1;
        hi=a;
        int l=(int)((B*(long)C)/lcm(B,C));
        //System.out.println("LCM="+l);
        ans=a;
        while(lo<=hi)
        {
            //System.out.println("Entering while loop----");
            mid=(lo+hi)/2;
            c=(mid/B)+(mid/C)-(mid/l);
            //System.out.println(mid+"   "+c);
            if(c>=A)
            {
                ans=mid;
                //System.out.println("Changing");
                hi=mid-1;
            }
            else{
               lo=mid+1; 
            }
        }
        return (int)(ans%m);
    }
}
