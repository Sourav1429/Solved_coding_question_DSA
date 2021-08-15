/*Given an array of integers A, every element appears twice except for one. Find that single one.

NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?*/
//Submit
int Solution::singleNumber(const vector<int> &A) {
    int ans=0;
    for(int i=0;i<A.size();i++)
        ans=ans^A[i];
    return ans;
}
