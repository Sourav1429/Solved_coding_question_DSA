/*Contiguous Array
Given an array of integers A consisting of only 0 and 1.

Find the maximum length of a contiguous subarray with equal number of 0 and 1.



Input Format

The only argument given is the integer array A.
Output Format

Return the maximum length of a contiguous subarray with equal number of 0 and 1.
Constraints

1 <= length of the array <= 100000
0 <= A[i] <= 1
For Example

Input 1:
    A = [1, 0, 1, 0, 1]
Output 1:
    4
    Explanation 1:
        Subarray from index 0 to index 3 : [1, 0, 1, 0]
        Subarray from index 1 to index 4 : [0, 1, 0, 1]
        Both the subarrays have equal number of ones and equal number of zeroes.

Input 2:
    A = [1, 1, 1, 0]
Output 2:
    2*/
    import java.util.HashMap;
class Solutio {
    public int min(int a,int b)
        {return (a>b)?b:a;}
    public int max(int a,int b)
    {
        return (a<b)?b:a;
    }
    public int solve(int[] A) {
        int l=A.length,i,count=0,sum=0,max=0;
        HashMap<Integer,Integer> hash=new HashMap<Integer,Integer>();
        hash.put(0,0);
        //System.out.println("Zeroes\tOnes");
        for(i=0;i<l;i++)
        {
            if(A[i]==0)
                sum-=1;
            else
                sum+=1;
           if(hash.get(sum)==null)
            hash.put(sum,i+1);
            else
            {
                //System.out.println(i+" "+sum);
                count=i+1-hash.get(sum);
                if(count>max)
                    max=count;
            }
        }
        return max;
    }
}
public class contiguous_array {
    public static void main(String[] args) {
        int A[]={0, 1, 1, 0,1 };
        Solutio s=new Solutio();
        System.out.print(s.solve(A));
    }
    
}
