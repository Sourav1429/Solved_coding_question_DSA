/*Q1. Prime Sum
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA & get it resolved
Get help from TA
Problem Description

Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to given number.

If there are more than one solutions possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then 
[a, b] < [c, d], If a < c OR a==c AND b < d. 
NOTE: A solution will always exist. Read Goldbach's conjecture.



Problem Constraints

4 <= A <= 2*107



Input Format

First and only argument of input is an even number A.



Output Format

Return a integer array of size 2 containing primes whose sum will be equal to given number.



Example Input

 4


Example Output

 [2, 2]


Example Explanation

 There is only 1 solution for A = 4.


See Expected Output*/
public class Solution {
    boolean SieveOfEratosthenes(int n, boolean isPrime[])
    {
        // Initialize all entries of boolean
        // array as true. A value in isPrime[i]
        // will finally be false if i is Not a
        // prime, else true bool isPrime[n+1];
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= n; i++)
            isPrime[i] = true;
     
        for (int p = 2; p * p <= n; p++)
        {
            // If isPrime[p] is not changed,
            // then it is a prime
            if (isPrime[p] == true)
            {
                // Update all multiples of p
                for (int i = p * p; i <= n; i += p)
                    isPrime[i] = false;
            }
        }
        return false;
    }
    public int[] primesum(int n) {
        boolean isPrime[]=new boolean[n + 1];
        SieveOfEratosthenes(n, isPrime);
        int arr[]=new int[2];
        // Traversing all numbers to find first
        // pair
        for (int i = 0; i < n; i++)
        {
            if (isPrime[i] && isPrime[n - i])
            {
                arr[1]=i;
                arr[0]=n-i;
            }
        }
    return arr;
    }
}
