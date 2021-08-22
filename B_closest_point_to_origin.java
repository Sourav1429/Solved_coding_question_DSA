/*B Closest Points to Origin
Problem Description

We have a list A, of points(x,y) on the plane. Find the B closest points to the origin (0, 0).

Here, the distance between two points on a plane is the Euclidean distance.

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)

NOTE: Euclidean distance between two points P1(x1,y1) and P2(x2,y2) is sqrt( (x1-x2)2 + (y1-y2)2 ).



Problem Constraints
1 <= B <= length of the list A <= 100000
-100000 <= A[i][0] <= 100000
-100000 <= A[i][1] <= 100000



Input Format
The argument given is list A and an integer B.



Output Format
Return the B closest points to the origin (0, 0) in any order.



Example Input
Input 1:

 A = [ 
       [1, 3],
       [-2, 2] 
     ]
 B = 1
Input 2:

 A = [
       [1, -1],
       [2, -1]
     ] 
 B = 1


Example Output
Output 1:

 [ [-2, 2] ]
Output 2:

 [ [1, -1] ]


Example Explanation
Explanation 1:

 The Euclidean distance will be sqrt(10) for point [1,3] and sqrt(8) for point [-2,2].
 So one closest point will be [-2,2].
Explanation 2:

 The Euclidean distance will be sqrt(2) for point [1,-1] and sqrt(5) for point [2,-1].
 So one closest point will be [1,-1].*/
//Submit and accepted in leetcode
public class Solution {
    public void sort(long arr[][],int l,int u)
    {
        if(l>=u-1)
            return;
        int pivot=u-1;long t,t1;
        int i,j=l-1;
        for(i=l;i<u-1;i++)
        {
            if(arr[i][0]<arr[pivot][0])
            {
                t=arr[i][0];
                t1=arr[i][1];
                j+=1;
                arr[i][0]=arr[j][0];
                arr[i][1]=arr[j][1];
                arr[j][0]=t;
                arr[j][1]=t1;
            }
        }
        j+=1;
        t=arr[pivot][0];
        t1=arr[pivot][1];
        arr[pivot][0]=arr[j][0];
        arr[pivot][1]=arr[j][1];
        arr[j][0]=t;
        arr[j][1]=t1;
        sort(arr,l,j);
        sort(arr,j+1,u);
    }
    public int[][] solve(int[][] A, int B) {
        int i,l=A.length,a;long arr[][]=new long[l][2];int arr2[][]=new int[B][2];long z;
        for(i=0;i<l;i++)
        {
            z=A[i][0]*A[i][0]+A[i][1]*A[i][1];
            arr[i][0]=z;
            arr[i][1]=i;
        }
        sort(arr,0,l);
        for(i=0;i<B;i++)
        {
            a=(int)(arr[i][1]);
            arr2[i][0]=A[a][0];
            arr2[i][1]=A[a][1];
        }
        return arr2;
    }
}
