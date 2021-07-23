/*Change character
Problem Description

Given a string A of size N consisting of lowercase alphabets.

You can change at most B characters in the given string to any other lowercase alphabet such that the number of distinct characters in the string is minimized.

Find the minimum number of distinct characters in the resulting string.



Problem Constraints
1 <= N <= 100000

0 <= B < N



Input Format
First argument is a string A.

Second argument is an integer B.



Output Format
Return an integer denoting the minimum number of distinct characters in the string.



Example Input
A = "abcabbccd"
B = 3



Example Output
2



Example Explanation
We can change both 'a' and one 'd' into 'b'.So the new string becomes "bbcbbbccb".
So the minimum number of distinct character will be 2.*/
import java.util.*;
class Solution{
    public int solve(String A,int B){
     int arr[]=new int[26],i,j,d=0,l=A.length();
     if(l<=B)
        return 0;
     for(i=0;i<l;i++)
     {
         j=(int)(A.charAt(i)-'a');
         arr[j]+=1;
     } 
     Arrays.sort(arr);
     for(i=0;i<26;i++)
        if(i>0)
        {
            d+=1;
            j=arr[i]-B;
            if(j<0)
            {
                B=B-arr[i];
                arr[i]=0;
                d-=1;
            }
            else if(j==0)
            {
                arr[i]=j;
                B=0;
                d-=1;
            }
            else{
                arr[i]=j;
                B=0;  
            }
        }
        return d;  
    }
}
public class change_character {
    public static void main(String[] args) {
        String A="abcabbccd";int B=3;
        Solution s=new Solution();
        System.out.println(s.solve(A,B));
    }
}
