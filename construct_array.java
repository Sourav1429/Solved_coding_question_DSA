/*Construct Array
Problem Description

Simba has an integer array of length A. Despite having insisted alot, He is not ready to reveal the array to his friend Expert. 
But now, he is ready to reveal some hints about the array and challenges Expert to find the values of his hidden array. 
 The hints revealed are as follows:

The array is sorted by values in ascending order.
All the elements in the array are distinct and positive (greater than 0).
The array contains two elements B and C such that B < C.
Difference between all adjacent (consecutive) elements are equal.
Among all the arrays satisfying the above conditions, his array has the minimum possible maximum element value.
If there are multiple possible arrays, his array will have minimum possible minimum element value.
Can you help Expert to construct such an array and surprise Simba?



Problem Constraints
2 <= A <= 50

1 <= B < C <= 50



Input Format
First argument is an integer A.

Second argument is an integer B.

Third argument is an integer C.



Output Format
Return a sorted integer array having length N, denoting Simba's Secret Array.



Example Input
Input 1:

 A = 5
 B = 20
 C = 50 
Input 2:

 A = 2
 B = 2
 C = 3 


Example Output
Output 1:

 [10, 20, 30, 40, 50]
Output 2:

 [2, 3]


Example Explanation
Explanation 1:

 Sorted array = [10, 20, 30, 40, 50] satisfies all the conditions having maximum value = 50 minimum possible.
 Other arrays such as [20, 30, 40, 50, 60] having max value = 60 or [20, 50, 80, 120] having max value = 120, 
 also satisfy conditions but their maximum value is not minimum possible(As minimum possible max value is 50). 
Explanation 2:

 As the array has only 2 elements, [2, 3] is the only possible candidate.*/
 import java.util.ArrayList;
 import java.util.Arrays;
 class Solution{
     public int sqrt(int a)
     {
         if(a==1 || a==0) return a;
         int l=1,u=a/2,mid,till_now=0;
         while(l<=u)
         {
             mid=(l+u)/2;
             if(mid*mid==a)
                return mid;
             else if(mid*mid>a)
                u=mid-1;
             else{
                 till_now=mid;
                 l=mid+1;
             }
         }
         return till_now;
     }
     public void solve(int A,int B,int C)
     {
         int val=C-B,i,d,c,lim=A,x1;
         ArrayList<Integer> fact=new ArrayList<Integer>();
         int arr[]=new int[A];
         int l=sqrt(val);
         for(i=1;i<=l;i++)
         {
             if(val%i==0)
                fact.add(i);
         }
         l=fact.size();
         for(i=l-1;i>=0;i--)
            fact.add(val/fact.get(i));
        l=fact.size();
        for(i=0;i<l;i++)
         System.out.print(fact.get(i)+" ");
         System.out.println("");
         i=0;
         do{
            d=fact.get(i);
            x1=val/d;
            if(x1<A)
                break;
            i+=1;
         }while(true);
         System.out.println("Common_difference:"+d);
         c=C;i=0;
         while(c>0 && A>0)
         {
             arr[i]=c;
             A-=1;
             i+=1;
             c-=d;
         }
         for(val=0;val<lim;val++)
            System.out.print(arr[val]+" ");
        System.out.println("");
         while(A>0)
         {
             arr[i]=C+A*d;
             A-=1;
             i+=1;
         }
         Arrays.sort(arr);
         for(i=0;i<lim;i++)
            System.out.print(arr[i]+" ");
     }
 }
public class construct_array {
    public static void main(String[] args) {
        int A=3,B=10,C=39;
        Solution s=new Solution();
        s.solve(A,B,C);
    }
}
