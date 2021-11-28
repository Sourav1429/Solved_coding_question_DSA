/*Problem Description

Given an array of integers A of size N containing GCD of every possible pair of elements of another array.

Find and return the original numbers which are used to calculate the GCD array in any order. For example, if original numbers are {2, 8, 10} then the given array will be {2, 2, 2, 2, 8, 2, 2, 2, 10}.



Problem Constraints

1 <= N <= 10000

1 <= A[i] <= 109



Input Format

The first and only argument given is the integer array A.



Output Format

Find and return the original numbers which are used to calculate the GCD array in any order.



Example Input

Input 1:

 A = [2, 2, 2, 2, 8, 2, 2, 2, 10]
Input 2:

 A = [5, 5, 5, 15]


Example Output

Output 1:

 [2, 8, 10]
Output 2:

 [5, 15]


Example Explanation

Explanation 1:

 Initially, array A = [2, 2, 2, 2, 8, 2, 2, 2, 10].
 2 is the gcd between 2 and 8, 2 and 10.
 8 and 10 are the gcds pair with itself.
 Therefore, [2, 8, 10] is the original array.
Explanation 2:

 Initially, array A = [5, 5, 5, 15].
 5 is the gcd between 5 and 15.
 15 is the gcds pair with itself.
 Therefore, [5, 15] is the original array.
*/
public class Solution {
    public void reverse(int []input)
    {
        int last = input.length - 1;
        int middle = input.length / 2;
        for (int i = 0; i <= middle; i++)
        {
            int temp = input[i];
            input[i] = input[last - i];
            input[last - i] = temp;
        }
    }
    int __gcd(int a, int b)
    {
        if (b == 0)
        {
            return a;
        }
        return __gcd(b, a % b);
 
    }
    public int[] solve(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        reverse(arr);
        int freq[] = new int[arr[0] + 1];
 
        // Count frequency of each element
        for (int i = 0; i < n; i++)
        {
            freq[arr[i]]++;
        }
 
        // Size of the resultant array
        int size = (int) Math.sqrt(n);
        int brr[] = new int[size], x, l = 0;
 
        for (int i = 0; i < n; i++)
        {
            if (freq[arr[i]] > 0 && l < size)
            {
 
                // Store the highest element in
                // the resultant array
                brr[l] = arr[i];
 
                // Decrement the frequency of that element
                freq[brr[l]]--;
                l++;
                for (int j = 0; j < l; j++)
                {
                    if (i != j)
                    {
 
                        // Compute GCD
                        x = __gcd(arr[i], brr[j]);
 
                        // Decrement GCD value by 2
                        freq[x] -= 2;
                    }
                }
            }
        }
        return brr;
    }
    
}
