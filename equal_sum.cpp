/*Equal
Problem Description

Given an array A of N integers, find the index of values that satisfy P + Q = R + S, where P,Q,R & S are integers values in the array

Expected time complexity O(N2)

NOTE:

1) Return the indices `A1 B1 C1 D1`, so that 
  A[A1] + A[B1] = A[C1] + A[D1]
  A1 < B1, C1 < D1
  A1 < C1, B1 != D1, B1 != C1 

2) If there are more than one solutions, 
   then return the tuple of values which are lexicographical smallest. 

Assume we have two solutions
S1 : A1 B1 C1 D1 ( these are values of indices in the array )  
S2 : A2 B2 C2 D2

S1 is lexicographically smaller than S2 if:
  A1 < A2 OR
  A1 = A2 AND B1 < B2 OR
  A1 = A2 AND B1 = B2 AND C1 < C2 OR 
  A1 = A2 AND B1 = B2 AND C1 = C2 AND D1 < D2
If no solution is possible, return an empty list.



Problem Constraints
1 <= N <= 1000

0 <= A[i] <= 1000



Input Format
Single argument which is an integer array A of size N.



Output Format
Return an array of size 4 which indexes of values P,Q,R and S.



Example Input
Input 1:

 A = [3, 4, 7, 1, 2, 9, 8]
Input 2:

 A = [2, 5, 1, 6]


Example Output
Output 1:

 [0, 2, 3, 5]
Output 2:

 [0, 1, 2, 3]


Example Explanation
Explanation 1:

 A[0] + A[2] = A[3] + A[5]
 Note: indexes returned should be 0-based.
Explanation 2:

 A[0] + A[1] = A[2] + A[3]*/
 #include<bits/stdc++.h>
 void check(std::vector<int> &A,std::vector<int> &B)
 {
     if(B[0]<A[0])
        {
            A[0]=B[0];A[1]=B[1];A[2]=B[2];A[3]=B[3];
            B.clear();
            return;
        }
    else if((B[0]==A[0])&&(B[1]<A[1]))
    {
      A[0]=B[0];A[1]=B[1];A[2]=B[2];A[3]=B[3];
      B.clear(); 
      return; 
    }
    else if((B[0]==A[0])&&(B[1]==A[1])&&(B[2]<A[2]))
    {
      A[0]=B[0];A[1]=B[1];A[2]=B[2];A[3]=B[3];
      B.clear(); 
      return; 
    }
    else if((B[0]==A[0])&&(B[1]==A[1])&&(B[2]==A[2])&&(B[3]<A[3]))
    {
      A[0]=B[0];A[1]=B[1];A[2]=B[2];A[3]=B[3];
      B.clear(); 
      return; 
    }
    B.clear();
 }
 std::vector<int> solve(std::vector<int> &A)
 {
     int l=A.size(),i,j,sum=0;std::vector<int> vect,min{l,l,l,l};
     std::map<int,std::vector<int>> hash;
     for(i=0;i<l;i++)
     {
         for(j=i+1;j<l;j++)
         {
             vect.clear();
             sum=A[i]+A[j];
             if(hash.find(sum)==hash.end())
             {
                vect.push_back(i);
                vect.push_back(j);
                hash.insert({sum,vect});
             }
            else{
                vect=hash[sum];
                if(vect[1]==i || vect[1]==j || vect[0]==i || vect[0]==j)
                    {vect.clear();continue;}
                vect.push_back(i);
                vect.push_back(j);
                //std::cout<<vect[0]<<","<<vect[1]<<","<<vect[2]<<","<<vect[3]<<'\n';
                check(min,vect);
            }
         }
     }
     return min;
 }
 int main()
 {
     std::vector<int> vect{2,-2,4,-4,6,-6},A;
     A=solve(vect);
     std::cout<<A[0]<<","<<A[1]<<","<<A[2]<<","<<A[3];
 }