/*Smallest sequence with given Primes
Problem Description

Given three prime number(A, B, C) and an integer D. Find the first(smallest) D integers which have only A, B, C or a combination of them as their prime factors.



Problem Constraints
1 <= A, B, C <= 10000

1 <= D <= 100000



Input Format
First argument is an integer A.
Second argument is an integer B.
Third argument is an integer C.
Fourth argument is an integer D.



Output Format
Return an integer array of size D, denoting the first D integers described above.

NOTE: The sequence should be sorted in ascending order



Example Input
Input 1:

 A = 2
 B = 3
 C = 5
 D = 5
Input 2:

 A = 3
 B = 2
 C = 7
 D = 3


Example Output
Output 1:

 [2, 3, 4, 5, 6]
Output 2:

 [2, 3, 4]


Example Explanation
Explanation 1:

 4 = A * A ( 2 * 2 ), 6 = A * B ( 2 * 3 )
Explanation 2:

 2 has only prime factor 2. Similary 3 has only prime factor 3. 4 = A * A ( 2 * 2 )*/
//Submit.
public class Solution {
    public int min(int a,int b,int c){
        int mini=a;
        if(b<mini)
            mini=b;
        if(c<mini)
            mini=c;
        return mini;
    }
    public int[] solve(int A, int B, int C, int D) {
        int arr[]=new int[D];
        int i,p1=-1,p2=-1,p3=-1,a,b,c,g;arr[0]=1;
        for(i=0;i<D;i++)
        {
            //System.out.println("Loop entry number:"+i);
            if(p1==-1)
                {a=A;}
            else
                {a=arr[p1]*A;}
            if(p2==-1)
                {b=B;}
            else
                {b=arr[p2]*B;}
            if(p3==-1)
                {c=C;}
            else
                {c=arr[p3]*C;}
            g=min(a,b,c);
            if(i>0 && arr[i-1]==g)
                i-=1;
            else
                arr[i]=g;
            if(a==arr[i])
                p1+=1;
            else if(b==arr[i])
                p2+=1;
            else if(c==arr[i])
                p3+=1;
        }
        return arr;
    }
}
