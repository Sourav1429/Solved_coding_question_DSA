import java.util.ArrayList;
class Solution{
    public void solve(int N)
    {
        ArrayList<Integer> arr=new ArrayList<Integer>();int i,j,k=0;
        arr.add(0);arr.add(0);
        for(i=2;i<=N;i++)
            arr.add(1);
        for(i=2;i*i<=N;i++)
        {
            if(arr.get(i)==1)
            {
                for(j=i*i;j<=N;j+=i)
                {
                    arr.set(j,0);
                }
            }
        }
        ArrayList<Integer> arr2=new ArrayList<Integer>();
        for(i=0;i<=N;i++)
        {
            if(arr.get(i)!=0)
               {
                   arr2.add(i);
                   System.out.print(i+" ");
               }
        }
    }
}
public class sieve_prime{
    public static void main(String[] args) {
        int N=100;
        Solution s=new Solution();
        s.solve(N);
    }
}