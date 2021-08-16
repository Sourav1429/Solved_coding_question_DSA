/*Find the Bth smallest element in given array A .

NOTE: Users should try to solve it in <= B swaps.



Problem Constraints
1 <= |A| <= 100000

1 <= B <= min(|A|, 500)

1 <= A[i] <= 109



Input Format
First argument is vector A.

Second argument is integer B.



Output Format
Return the Bth smallest element in given array.



Example Input
Input 1:

A = [2, 1, 4, 3, 2]
B = 3
Input 2:

A = [1, 2]
B = 2


Example Output
Output 1:

 2
Output 2:

 2


Example Explanation
Explanation 1:

 3rd element after sorting is 2.
Explanation 2:

 2nd element after sorting is 2.
*/
//Submit
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int kthsmallest(final int[] A, int B) {
        int i,l=A.length,j,pos,min;
        /*Arrays.sort(A);
        for(i=0;i<l;i++)
        {
            if(A[i]!=A[i+1])
                arr.add(A[i]);
        }
        return arr.get(B);*/
        for(i=0;i<l;i++)
        {
            min=A[i];
            pos=i;
            for(j=i+1;j<l;j++)
            {
                if(A[j]<min)
                {
                    min=A[j];
                    pos=j;
                }
            }
            if(i==B-1)
                return min;
            A[pos]=A[i];
            A[i]=min;
        }
        return -1;
    }
}
