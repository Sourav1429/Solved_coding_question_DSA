/*An n x n matrix is valid if every row and every column contains all the integers from 1 to n (inclusive).

Given an n x n integer matrix matrix, return true if the matrix is valid. Otherwise, return false.

 

Example 1:


Input: matrix = [[1,2,3],[3,1,2],[2,3,1]]
Output: true
Explanation: In this case, n = 3, and every row and column contains the numbers 1, 2, and 3.
Hence, we return true.
Example 2:


Input: matrix = [[1,1,1],[1,2,3],[1,2,3]]
Output: false
Explanation: In this case, n = 3, but the first row and the first column do not contain the numbers 2 or 3.
Hence, we return false.
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 100
1 <= matrix[i][j] <= n
Link: https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/
*/

/* Explanation:
n the contest on Sunday, My solution was accepted but still that range [1,n] gave me an intuition that I can definetly decrease the space Complexity, thx to god I found it.

Approach - O(1) Space :

Interviewer might give us hint about range [1,N], like in this question, we can defintely use this to solve this question.

This Question is a clear variation of 287. Find the Duplicate Number.

We can use indexes as marking places for every value.

Value =1 => mark will be at index 0
Value =2 => mark will be at index 1
................................
Value =n => mark will be at index n-1 
Useful Trick I learnt :
Whenever we see some question is saying something about elements range [1,N] in an array, the question might be a variation of 287. Find the Duplicate Number.

Algorithm:
The approach is exactly same as 287. Find the Duplicate Number, but the difference is we have check every row and every column.

First traverse ROW-WISE and mark every element's position in their respective column of particular row as mat[i][value-1], check if it's been marked negative by any other number, if any point we see that it's place already marked, return false, otherwise keep doing it and keep marking their places as negative.

In the above iteration we used negative for marking the position because the intital values were positive , but now array has become negative, so we will do just opposite for checking COLUMN-WISE by marking their position it by a positive and return false if already marked positive and approach is same as above, only negative marking is be changed to postive marking.

In this way our Total space is constant and our 2D matrix remains uneffected.
C++*/
bool checkValid(vector<vector<int>>& mat){
     int n= mat.size();	

     //mark position by making negative from positive ROW-WISE
     for(int i=0;i<n;i++){
         for(int j=0;j<n;j++){
             int pos= abs(mat[i][j]) -1 ;  // Getting position by value

             if( mat[i][pos] < 0 ) return false;    //If place already marked 
             mat[i][pos] = -mat[i][pos];    //Mark Place
         }
     }

     //mark position by making negative to positive COLUMN-WISE
     for(int i=0;i<n;i++){
         for(int j=0;j<n;j++){
             int pos= abs(mat[j][i]) -1 ;   // Getting position by value

             if( mat[pos][i] > 0 ) return false;    //If place already marked 
             mat[pos][i]= abs(mat[pos][i]);        //Mark Place
         }
     }

     return true;
}
