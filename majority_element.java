/*Majority Element
Problem Description

Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.
You may assume that the array is non-empty and the majority element always exist in the array.

Example :

Input : [2, 1, 2]
Return  : 2 which occurs 2 times which is greater than 3/2.*/
import java.util.*;
class Solution{
    public int method1(int A[]){
        int l=A.length,i;
        HashMap<Integer,Integer> hash=new HashMap<Integer,Integer>();
        for(i=0;i<l;i++)
        {
            if(hash.get(A[i])==null)
                hash.put(A[i],1);
            else
                hash.put(A[i],hash.get(A[i])+1);
        }
        Set<Integer> keys = hash.keySet();
        for ( int key : keys ) {
            if((hash.get(key))>(Math.floor(l/2)))
                return key;
        }
        return -1;
    }
    public int method2(int A[])
    {
        int l=A.length,i,max=A[0],count=1;
        for(i=1;i<l;i++)
        {
            if(count==0)
            {
                max=A[i];
                count+=1;
            }
            else if(A[i]==max)
                count+=1;
            else{
                count-=1;
            }
        }
        return max;

    }
}

public class queries{
    public static void main(String[] args) {
        int A[]={2,1,2,1,3,1,3};
        //int B[]={0,1,1,0,0};
        Solution s=new Solution();
        Scanner in=new Scanner(System.in));
      System.out.println("Main Menu\n Press 1 to get answer with SC O(N)\n Press 2 to get answer in O(1) SC");
      char ch=in.nextChar();
      switch(ch){
        case 1:
          System.out.println(s.method1(A));
            break;
        case 2:
          System.out.println(s.method2(A));
          break;
        default:
          System.out.println("Wrong choice");
      }
    }
}
