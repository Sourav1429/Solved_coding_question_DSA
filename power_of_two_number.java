/*Given a positive integer which fits in a 32 bit signed integer, find if it can be expressed as A^P where P > 1 and A > 0. A and P both should be integers.

Example

Input : 4
Output : True  
as 2^2 = 4. */
public class Solution {
    public int isPower(int A) {
        if(A==0)
            return 0;
        if(A==1)
            return 1;
        int l=0,u=A,mid,n=(int)(Math.sqrt(A)),i,a;double b;
        for(i=2;i<=n;i++)
        {
            a=(int)(Math.log(A)/Math.log(i));
            b=Math.pow(i,a);
            if(b==A)
                {return 1;}
        }
        return 0;
    }
}
