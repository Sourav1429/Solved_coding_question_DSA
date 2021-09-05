/*Pairs with given sum II
Problem Description

Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 10^9

1 <= B <= 10^9



Input Format
The first argument given is the integer array A.

The second argument given is integer B.



Output Format
Return the number of pairs for which sum is equal to B modulo (10^9+7).



Example Input
Input 1:

A = [1, 1, 1]
B = 2
Input 2:

 
A = [1, 1]
B = 2


Example Output
Output 1:

 3
Output 2:

 1


Example Explanation
Explanation 1:

 Any two pairs sum up to 2.
Explanation 2:

 only pair (1, 2) sums up to 2.*/

//Approach 1: Using Hashmap   Time complexity: O(N) and space complexity: O(N)
int fast(int a,int b,int m){
        if(a==0)
            return 0;
        if(b==0)
            return 1;
        int t;
        if(b%2==0)
        {
            a=(int)(((long)a%m*a%m)%m);
            return (fast(a,b/2,m))%m;
        }
        else
            {
                t=a;
                a=(int)(((long)a%m*a%m)%m);
                return (int)(((((long)t)%m)*(fast(a,b/2,m))%m)%m);
                
            }
    }
int Solution::solve(vector<int> &A, int B) {
    int i,a,b,l=A.size(),m=1000000007;long cnt=0;
    i=0;
    map<int,int> hash;
    for(i=0;i<l;i++)
    {
        hash[A[i]]+=1;
    }
    for(i=0;i<l;i++)
    {
        a=B-A[i];
        if(hash.find(a)==hash.end())
            continue;
        else{
            b=hash[a];
            cnt=(cnt%m+b%m)%m;
        }
    }
    a=B/2;
    if(B==2*a){
    if(hash[B/2]!=NULL)
        cnt=(cnt-hash[B/2])%m;}
    return (int)((cnt%m*fast(2,m-2,m)%m)%m);
}
//Approach 2 : 2 pointer approach Time complexity O(N) and space complexity O(1)
const int mod = (int)(1e9 + 7);
int Solution::solve(vector < int > & A, int B) {
   int n = A.size(), i = 0, j = n - 1;
   long count = 0;
   while (i < j) {
      int sum = A[i] + A[j];
      if (sum == B) {
         if (A[i] != A[j]) {
            int a = 1, b = 1;
            while (i + 1 < j && A[i] == A[i + 1]) i++, a++;
            while (j - 1 > i && A[j] == A[j - 1]) j--, b++;
            count = (count + (a * 1 l * b) % mod) % mod;
            i++, j--;
         } else { // equal A[i] == A[j]
            int cnt = 1;
            // while(i+1<=j && A[i]==A[i+1]) cnt++,i++;
            cnt = (j - i + 1);
            cnt = (cnt * 1 ll * (cnt - 1) / 2) % mod;
            count = (cnt + count) % mod;
            // cout << cnt << " @@ " << count << endl;
            break;
         }
      } else if (sum > B)
         j--;
      else i++;
   }
   return count;
}
