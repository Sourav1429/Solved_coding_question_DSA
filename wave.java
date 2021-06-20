/*
Wave Array
Problem Description

Given an array of integers A, sort the array into a wave like array and return it, In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....

NOTE : If there are multiple answers possible, return the one that's lexicographically smallest.



Problem Constraints
1 <= len(A) <= 106
1 <= A[i] <= 106



Input Format
First argument is an integer array A.



Output Format
Return an array arranged in the sequence as described.



Example Input
Input 1:

A = [1, 2, 3, 4]
Input 2:

A = [1, 2]


Example Output
Output 1:

[2, 1, 4, 3]
Output 2:

[2, 1]


Example Explanation
Explanation 1:

One possible answer : [2, 1, 4, 3]
Another possible answer : [4, 1, 3, 2]
First answer is lexicographically smallest. So, return [2, 1, 4, 3].
Explanation 1:

Only possible answer is [2, 1].*/
public class Solution {
    public void sort(ArrayList<Integer> A,int l,int u)
    {
        if(l>=u)
            return;
        int pivot=A.get(u-1),loc=l-1,i,t;
        for(i=l;i<u-1;i++)
        {
            if(A.get(i)<pivot){
            loc+=1;
            t=A.get(i);
            A.set(i,A.get(loc));
            A.set(loc,t);
            }
            
        }
        loc+=1;
        t=A.get(u-1);
        A.set(u-1,A.get(loc));
        A.set(loc,t);
        sort(A,l,loc);
        sort(A,loc+1,u);
    }
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        int i,l=A.size(),t;
    sort(A,0,l);
    for(i=0;i<l-1;i+=2)
    {
        t=A.get(i);
        A.set(i,A.get(i+1));
        A.set(i+1,t);
        
    }
    return A;
    }
  public void main(String[] args)
  {
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    ArrayList<Integer> A=new ArrayList<Integer>();
    ArrayList<Integer> final_A=new ArrayList<Integer>();
    N=Integer.parseInt(br.readLine());
    for(i=0;i<N;i++)
    {
      A.add(Integer.pasrseInt(br.readLine()));
    }
    final_A=wave(A);
    for(i=0;i<N;i++)
      System.out.println(final_A.get(i));
  }
}
