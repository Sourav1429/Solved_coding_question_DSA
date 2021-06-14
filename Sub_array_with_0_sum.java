/*Sub-array with 0 sum
Problem Description

Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.

If the given array contains a sub-array with sum zero return 1 else return 0.



Problem Constraints
1 <= |A| <= 100000

-10^9 <= A[i] <= 10^9



Input Format
The only argument given is the integer array A.



Output Format
Return whether the given array contains a subarray with a sum equal to 0.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [-1, 1]


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation
Explanation 1:

 No subarray has sum 0.
Explanation 2:

 The array has sum 0.
 */
//Edge cases faced
//1) Starting the hash with zero: if our array is something like [-1,1,9,8], our required subarray should be [-1,1] so we should initially store 0 to our hashmap
//2) The constraints given are so big that if we take our sum as an intger variable, it may overflow go past the positive range i.e. Integer.MAX_VALUE and then move to the negative end. Thus, in those cases answers will be incorrect.
//So I took sum as of long data type. But it may also create issues so choose according to the constraints.
public class Solution {
    public int solve(int[] A) {
        int l=A.length,i;long sum=0L;
        if(l==0)
            return 0;
        HashMap<Long,Integer> hash=new HashMap<Long,Integer>();
        hash.put(sum,1);
        for(i=0;i<l;i++)
        {
            sum+=A[i];
            if(hash.get(sum)==null)
                hash.put(sum,1);
            else
                return 1;
        }
        return 0;
        
    }
  public void main(String[] args)
  {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter size and then numbers with after a carraige return");
    int N=Integer.parseInt(br.readLine()),i;
    int arr[]=new int[N];
    for(i=0;i<N;i++)
    {
      arr[i]=Integer.parseInt(br.readLine());
    }
    System.out.print(solve(arr));
  }
}
