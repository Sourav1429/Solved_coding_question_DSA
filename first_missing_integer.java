/*
Given an unsorted integer array, find the first missing positive integer.

Example:

Given [1,2,0] return 3,

[3,4,-1,1] return 2,

[-8, -7, -6] returns 1

Your algorithm should run in O(n) time and use constant space.*/
public class Solution {
    public int firstMissingPositive(int[] a) 
    {
        int n = a.length, flag = 0;
        for(int i=0;i<n;i++)
        {
            if(a[i]==1)
                flag = 1;
        }
        if(flag == 0)
            return 1;
        for(int i=0;i<n;i++)
        {
            if(a[i]<1 || a[i]>n)
                a[i]=1;
        }
        for(int i=0;i<n;i++)
        {
            a[(a[i]-1)%n]+=n;
        }
        for(int i=0;i<n;i++)
        {
            if(a[i]/n<1)
                return i+1;
        }
        return n+1;
    }
}
//If constant space not specified we can use hashmap like my solution but it is not valid here
/*
import java.util.*;
class Solution{
    public int solve(int A[],int N){
        int i,l1=A.length;
        HashMap<Integer,Integer> hash=new HashMap<Integer,Integer>();
        for(i=0;i<l1;i++)
        {
            if(hash.get(A[i])==null)
                hash.put(A[i],1);
            else
            hash.put(A[i],hash.get(A[i])+1);
        }
        for(i=1;i<=N;i++)
        {
            if(hash.get(i)==null)
                return i;
        }
        return N+1;
    }
}
public class find_missing_number {
    public static void main(String[] args) {
        int A[]={};
        Solution s=new Solution();
        System.out.print(s.solve(A,N));
    }
    
}*/
