/*Unique Elements
Problem Description

You are given an array A of N elements. You have to make all elements unique, to do so in one step you can increase any number by one.

Find the minimum number of steps.



Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109



Input Format
The only argument given is an Array A, having N integers.



Output Format
Return the Minimum number of steps required to make all elements unique.



Example Input
Input 1:

 A = [1, 1, 3]
Input 2:

 A = [2, 4, 5]


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 We can increase the value of 1st element by 1 in 1 step and will get all unique elements. i.e [2, 1, 3].
Explanation 2:

 All elements are distinct.*/
//Their solution
public class Solution {
    public int solve(int[] A) {
        int n = A.length;
        // sort the array
        Arrays.sort(A);
        // initialize variables
        int steps = 0, i = 1, j = 0;
        // loop unitil you reach the end
        while (j < n) {
            // make current element unique
            if (i >= A[j]) {
                steps += (i - A[j++]);
                i += 1;
            } else {
                i = A[j] + 1;
                j += 1;
            }
        }
        // return the answer
        return steps;
    }
  public void main(String[] args)
  {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    int n=Integer.parseInt(br.readLine());
    int arr=new int[n];
    for(i=0;i<n;i++)
    {
      arr[i]=Integer.parseInt(br.readLine());
    }
    System.out.println(solve(arr));
  }
}
//My solution
/*public class Solution {
    public int solve(int[] A) {
        int l=A.length,count=0;
        //sort(A,0,l);
        int i=0;
        HashMap<Integer,Integer> hash=new HashMap<Integer,Integer>();
        while(i<l)
        {
            if(hash.get(A[i])==null)
            {
                hash.put(A[i],1);
                i+=1;
            }
            else
            {
                A[i]+=1;
                count+=1;
            }
        }
        return count;
    }
}*/
