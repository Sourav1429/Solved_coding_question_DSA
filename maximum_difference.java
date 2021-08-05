/*
 Get on call with TA  Ask for Help
Bookmark

bookmark-empty
Maximum Difference
Given an array of integers A and an integer B. Find and return the maximum value of | s1 - s2 |

where s1 = sum of any subset of size B, s2 = sum of elements of A - sum of elemets of s1

Note |x| denotes the absolute value of x.


Input Format

The arguments given are the integer array A and integer B.
Output Format

Return the maximum value of | s1 - s2 |.
Constraints

1 <= B < length of the array <= 100000
1 <= A[i] <= 10^5 
For Example

Input 1:
    A = [1, 2, 3, 4, 5]
    B = 2
Output 1:
    9

Input 2:
    A = [5, 17, 100, 11]
    B = 3
Output 2:
    123*/
import java.util.Arrays;
class Solution{
    public int max(int a,int b)
        {return (a>b)?a:b;}
    public int solve(int A[],int B)
    {
        Arrays.sort(A);
        int i,s1=0,s2=0;
        for(i=0;i<l;i++)
        {
            if(i<B)
                s1+=A[i];
            s2+=A[i];
        }
        return max(2*s1-s2,s2-2*s1);
    }
} 
public class maximum_difference {
    Solution s=new Solution();
    int A[]={5, 17, 100, 11};
    System.out.println(s.solve(A,3));
}
