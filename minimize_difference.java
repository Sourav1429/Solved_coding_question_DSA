/*Minimize Difference
Problem Description

Given an array of integers A of size, N. Minimize the absolute difference between the maximum and minimum element of the array.

You can perform two types of operations at most B times in total to change the values in the array.
Multiple operations can be performed on the same element.

Increment : A[i] -> A[i] + 1.

Decrement : A[i] -> A[i] - 1.

Return the minimum difference possible.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 106

1 <= B <= 109



Input Format
First argument is an integer array A.
Second argument is an integer B which represents the maximum number of operations that can be performed.



Output Format
Return an integer denoting the minimum difference.



Example Input
Input 1:

 A = [2, 6, 3, 9, 8]
 B = 3
Input 2:

 A = [4, 6, 3, 1, 4]
 B = 5


Example Output
Output 1:

 5
Output 2:

 1


Example Explanation
Explanation 1:

 We can apply the atmost 3 operations in the following sequence.
 Initial array => [2, 6, 3, 9, 8].
   Decrement 9 => [2, 6, 3, 8, 8].
   Increment 2 => [3, 6, 3, 8, 8].
   Increment 3 => [3, 6, 4, 8, 8].
 Max = 8. Min = 3.
 Therefore, abs|Max - Min| = |8 - 3| = 5.
Explanation 2:

 We can apply the atmost 5 operations in the following sequence.
 Initial array => [4, 6, 3, 1, 4].
   Increment 1 => [4, 6, 3, 2, 4].
   Decrement 6 => [4, 5, 3, 2, 4].
   Increment 2 => [4, 5, 3, 3, 4].
   Decrement 5 => [4, 4, 3, 3, 4].
   Increment 3 => [4, 4, 4, 3, 4].
 Max = 4. Min = 3.
 Therefore, abs|Max - Min| = |4 - 3| = 1.*/
public class minimize_difference {
  public static int solve(int A[],int B)
  {
    int max=A[0],min=A[0],i,ret_val,f_ret_val=Integer.MAX_VALUE,max_p=0,min_p=0,l=A.length,max_d,min_d,min_cnt=0,max_cnt=0;
    while(B-->0)
    {
      max=A[0];min=A[0];max_p=0;min_p=0;
      for(i=1;i<l;i++)
      {
        if(A[i]>max)
          {max=A[i];max_p=i;max_cnt=1;}
        if(A[i]==max)
            max_cnt+=1;
        if(A[i]<min)
          {min=A[i];min_p=i;min_cnt=1;}
        if(A[i]==min)
            min_cnt+=1;
      }
      //Trying with dec max
      //System.out.println(B+" "+max+" "+min);
      A[max_p]-=1;
      //System.out.println(A[max_p]+" "+A[min_p]);
      max=A[0];min=A[0];
      for(i=1;i<l;i++)
      {
        if(A[i]>max)
          {max=A[i];}
        if(A[i]<min)
          {min=A[i];}
      }
      max_d=max-min;
      //System.out.println(max_d);
      if(max_d<0)
        max_d*=-1;
      A[max_p]+=1;A[min_p]+=1;
      //System.out.println(A[max_p]+" "+A[min_p]);
      max=A[0];min=A[0];
      for(i=1;i<l;i++)
        {
          if(A[i]>max)
            {max=A[i];}
          if(A[i]<min)
            {min=A[i];}
        }
        min_d=max-min;
        if(min_d<0)
          min_d*=-1;
        //System.out.println(min_d);
      if(max_d>min_d)
      {
        ret_val=min_d;
      }
      else if(max_d<min_d){
        ret_val=max_d;
        A[min_p]-=1;
        A[max_p]-=1;
      }
      else{
        if(max_cnt>min_cnt)
        {
          ret_val=min_d; 
        }
        else
        {
        ret_val=max_d;
        A[min_p]-=1;
        A[max_p]-=1;
        }
      }
      /*for(i=0;i<l;i++)
        System.out.print(A[i]+" ");
      System.out.println("\n"+ret_val+"\n--------------------");*/
      f_ret_val=(ret_val>f_ret_val)?f_ret_val:ret_val;
    }
    //System.out.println(max+" "+min);
    return f_ret_val;
  }
  public static void main(String[] args) {
    int A[]={2, 8, 3, 7, 8, 7, 9};
    int B=9;
    System.out.println(solve(A,B));
  }
    
}
