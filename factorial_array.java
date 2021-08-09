/*Factorial Array
Problem Description

Groot has an array A of size N. Boring right? Groot thought so too, so he decided to construct another array B of the same size and defined elements of B as:

B[i] = factorial of A[i] for every i such that 1<= i <= N.

factorial of a number X denotes (1 x 2 x 3 x 4......(X-1) x (X)).
Now Groot is interested in the total number of non-empty subsequences of array B such that every element in the subsequence has the same non empty set of prime factors.

Since the number can be very large, return it modulo 109 + 7.

NOTE: A set is a data structure having only distinct elements. Eg : the set of prime factors of Y=12 will be {2,3} and not {2,2,3}



Problem Constraints
1 <= N <= 105
1 <= A[i] <= 106
Your code will run against a maximum of 5 test cases.



Input Format
Only argument is an integer array A of size N.



Output Format
Return an integer deonting the total number of non-empty subsequences of array B such that every element in the subsequence has the same set of prime factors modulo 109+7.



Example Input
Input 1:

 A = [2, 3, 2, 3]
Input 2:

 A = [2, 3, 4]


Example Output
Output 1:

 6
Output 2:

 4


Example Explanation
Explanation 1:

 Array B will be : [2, 6, 2, 6]
 The total possible subsequences are 6 : [2], [2], [2, 2], [6], [6], [6, 6].
Input 2:

 Array B will be : [2, 6, 24]
 The total possible subsequences are 4 : [2], [6], [24], [6, 24].*/
//Submit
public class Solution {
    ArrayList<Integer> arr=new ArrayList<Integer>();int i,j,k=0;
    public void compute_sieve(int N)
    {
        arr.add(0);arr.add(0);
        for(i=2;i<=N;i++)
            arr.add(1);
        for(i=2;i*i<=N;i++)
        {
            if(arr.get(i)==1)
            {
                for(j=i*i;j<=N;j+=i)
                {
                    arr.set(j,0);
                }
            }
        }
    }
    public int sieve(int N)
    {
        for(i=N;i>=0;i--)
        {
            if(arr.get(i)!=0)
               {
                   return i;
               }
        }
        return 0;
    }
    public int solve(int[] A) {
        HashMap<Integer,Integer> hash=new HashMap<Integer,Integer>();
        ArrayList<Integer> arr=new ArrayList<Integer>();int a,i,N=A.length,max=A[0];long sum=0l;int m=1000000007;
        for(i=0;i<N;i++)
            if(A[i]>max)
                max=A[i];
        compute_sieve(max);
        for(i=0;i<N;i++)
        {
            a=sieve(A[i]);
            if(a!=0)
            {
            if(hash.get(a)==null)
                {
                    hash.put(a,1);
                    arr.add(a);
                }
            else
                hash.put(a,hash.get(a)+1);
            }
        }
        N=arr.size();
        for(i=0;i<N;i++)
        {
            sum=(sum%m+(long)(Math.pow(2,hash.get(arr.get(i)))%m-1)%m)%m;
        }
       return (int)(sum);
    }
}
