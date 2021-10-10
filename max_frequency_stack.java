/*Maximum Frequency stack
Problem Description

You are given a matrix A which represent operations of size N x 2. Assume initially you have a stack-like data structure you have to perform operations on it.

Operations are of two types:

1 x: push an integer x onto the stack and return -1

2 0: remove and return the most frequent element in the stack.

If there is a tie for the most frequent element, the element closest to the top of the stack is removed and returned.

A[i][0] describes the type of operation to be performed. A[i][1] describe the element x or 0 corresponding to the operation performed.



Problem Constraints
1 <= N <= 100000

1 <= A[i][0] <= 2

0 <= A[i][1] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return the array of integers denoting answer to each operation.



Example Input
Input 1:

A = [
            [1, 5]
            [1, 7]
            [1, 5]
            [1, 7]
            [1, 4]
            [1, 5]
            [2, 0]
            [2, 0]
            [2, 0]
            [2, 0]  ]
Input 2:

 A =  [   
        [1, 5]
        [2 0]
        [1 4]   ]


Example Output
Output 1:

 [-1, -1, -1, -1, -1, -1, 5, 7, 5, 4]
Output 2:

 [-1, 5, -1]


Example Explanation
Explanation 1:

 Just simulate given operations
Explanation 2:

 Just simulate given operations*/
//Submit.
public class Solution {
    public int[] solve(int[][] A) {
        HashMap<Integer,Integer> hash1=new HashMap<Integer,Integer>();
        HashMap<Integer,Stack<Integer>> hash2=new HashMap<Integer,Stack<Integer>>();
        int l=A.length,a,max=0,i,u,x,k,val,flag=0;
        Stack<Integer> st;int arr[]=new int[l];
        for(i=0;i<l;i++)
        {
            u=A[i][0];
            x=A[i][1];
            if(u==1)
            {
                arr[i]=-1;
                if(hash1.get(x)==null)
                {
                    hash1.put(x,1);
                    a=1;
                    if(hash2.get(a)==null)
                    {
                        st=new Stack<Integer>();
                        st.push(x);
                        hash2.put(a,st);
                    }
                    else{
                        st=hash2.get(a);
                        st.push(x);
                        hash2.put(a,st);
                    }
                }
                else{
                    a=hash1.get(x);
                    a=a+1;
                    hash1.put(x,a);
                    if(hash2.get(a)==null)
                    {
                        st=new Stack<Integer>();
                        st.push(x);
                        hash2.put(a,st);
                    }
                    else{
                        st=hash2.get(a);
                        st.push(x);
                        hash2.put(a,st);
                    }
                }
            }
            else{
                flag=0;
                for (Map.Entry j : hash1.entrySet()) {
                    k=(int)(j.getKey());
                    if(hash1.get(k)==null || hash1.get(k)==-1)
                        continue;
                    val=hash1.get(k);
                    if(flag==0)
                    {
                        max=val;
                        flag=1;
                    }
                    else if(val>max)
                    {
                        max=val;
                    }
            }
            arr[i]=hash2.get(max).pop();
            hash1.put(arr[i],hash1.get(arr[i]-1));
        }
    }
    return arr;
}
}

