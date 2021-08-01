/*Add One To Number
Problem Description

Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: for this problem, following are some good questions to ask :

Q : Can the input have 0's before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
A : For the purpose of this question, YES
Q : Can the output have 0's before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.


Problem Constraints
1 <= size of the array <= 1000000



Input Format
First argument is an array of digits.



Output Format
Return the array of digits after adding one.



Example Input
Input 1:

[1, 2, 3]


Example Output
Output 1:

[1, 2, 4]


Example Explanation
Explanation 1:

Given vector is [1, 2, 3].
The returned vector should be [1, 2, 4] as 123 + 1 = 124.*/
//Submit
public class Solution {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int l=A.size(),i,t;ArrayList<Integer> arr=new ArrayList<Integer>();
        for(i=0;i<l/2;i++)
        {
            t=A.get(i);
            A.set(i,A.get(l-i-1));
            A.set(l-i-1,t);
        }
        int c=1;i=0;
        while(c!=0 && i<l)
        {
            t=A.get(i)+c;
            c=t/10;
            t=t%10;
            A.set(i,t);
            i+=1;
        }
        if(c==1)
          {
              A.add(c);
              l+=1;
          }
         for(i=0;i<l/2;i++)
        {
            t=A.get(i);
            A.set(i,A.get(l-i-1));
            A.set(l-i-1,t);
        }
        for(i=0;i<l;i++)
            if(A.get(i)!=0)
                break;
        for(;i<l;i++)
            arr.add(A.get(i));
        return arr;
            
    }
}
