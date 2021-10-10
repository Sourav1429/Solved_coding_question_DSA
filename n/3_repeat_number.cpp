/*N/3 Repeat Number
Problem Description

You're given a read only array of n integers. Find out if any integer occurs more than n/3 times in the array in linear time and constant additional space.
If so, return the integer. If not, return -1.

If there are multiple solutions, return any one.

Example:

Input: [1 2 3 1 1]
Output: 1 
1 occurs 3 times which is more than 5/3 times.*/
//Submit. Pleae save the geeks for geeks link and the final solution for understanding
//Submit. Pleae save the geeks for geeks link and the final solution for understanding
int Solution::repeatedNumber(const vector<int> &A) {
    // Do not write main() function.
    // Do not read input, instead use the arguments to the function.
    // Do not print the output, instead return values as specified
    // Still have a doubt. Checkout www.interviewbit.com/pages/sample_codes/ for more details
    int i,l=A.size(),first=-1,second=-1,count1,count2;
    count1=count2=0;
    for(i=0;i<l;i++)
    {
        if(first==A[i])
        {
            count1+=1;
        }
        else if(second==A[i])
        {
            count2+=1;
        }
        else if(count1==0)
        {
            first=A[i];
            count1+=1;
        }
        else if(count2==0)
        {
            second=A[i];
            count2+=1;
        }
        else{
            count1-=1;
            count2-=1;
        }
    }
    count1=0;count2=0;
    for(i=0;i<l;i++)
    {
        if(A[i]==first)
            count1+=1;
        else if(second==A[i])
        {
            count2+=1;
        }
    }
    if(count1>l/3)
        return first;
    if(count2>l/3)
        return second;
        return -1;
}
//GEEKS FOR GEEKS LINK: https://www.geeksforgeeks.org/n3-repeated-number-array-o1-space/
//BASED ON MOORE's Voting Algorithm
