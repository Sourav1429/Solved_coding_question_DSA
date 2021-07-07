/*Lexicographically Largest
You are given a string S. You want to change it to the lexicographically largest possible string by changing some of its characters. 
But you can only use characters of the string T as a replacement for characters of S. Formally, find the lexicographically largest string you 
can form by replacing some(or none) of the characters of S by using only the characters of string T. Note: Each character of T can be used at
the most once.

Constraints:

1.   1 <= Length of S and T <= 50
2.   All the alphabets of S and T are lower case (a - z)
Input: A string A containing S and T separated by "_" character. (See example below)

Output: Lexicographically largest string P that can be formed by changing some or (none) characters of S using the characters of T.

Example:

Input:

A : "abb_c"
This implies S is "abb" and T is "c".

Output:

P = "cbb"*/
import java.util.*;
class Solution{
    public void reverse(char[] a)
    {
        int i, n = a.length;
        char t;
        for (i = 0; i < n / 2; i++)
        {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
    }
    public String sort(String A)
    {
        char t[]=A.toCharArray();
        Arrays.sort(t);
        reverse(t);
        return (new String(t));
    }
    public String solve(String A){
        char tempArray[]=A.toCharArray();int l=A.length(),i;
        for(i=0;i<l;i++)
        {
            if(tempArray[i]=='_')
                break;
        }
        //System.out.println(i);
        int l1=i,l2=l-i-1;
        String S="",T="",ret_val="";
        for(i=0;i<l1;i++)
        {
            S=S+Character.toString(tempArray[i]);
        }
        for(i=l1+1;i<l;i++)
        {
            T=T+Character.toString(tempArray[i]);
        }
        System.out.println(S+" "+T);
        //S=sort(S);
        T=sort(T);
        System.out.println(S+" "+T);
        i=0;int j=0;
        while(i<l1 && j<l2)
        {
            if(S.charAt(i)>=T.charAt(j))
            {
                ret_val=ret_val+S.charAt(i);
            }
            else{
                ret_val=ret_val+T.charAt(j);
                j+=1;
            }
            i+=1;
        }
        while(i<l1)
        {
            ret_val=ret_val+S.charAt(i);
            i+=1;
        }
        return ret_val;
    }
}
public class lexico_largest {
    public static void main(String[] args) {
        String A="abb_c";
        Solution s=new Solution();
        System.out.println(s.solve(A));
    }
    
}
