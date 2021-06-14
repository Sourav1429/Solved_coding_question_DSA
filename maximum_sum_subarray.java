/* The aim here is to find the subarray having the maximum sum value along with the index positions of the array
*/
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int solve(int[] A) {
        int sum=0,sum2=Integer.MIN_VALUE,l=A.length,i,flag=1,init_pos=-1,final_pos=0;
        for(i=0;i<l;i++)
        {
            sum+=A[i];
            if(sum>sum2)
            {
                sum2=sum;
                if(flag==1)
                    {init_pos=i;flag=0;}
                final_pos=i;
            }
            if(sum<0)
            {
                sum=0;
                flag=1;
            }
        }
        System.out.print(init_pos+" "+final_pos);
        return sum2;
    }
public void main(String[] args)
  {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter size and then numbers with after a carraige return");
    int N=Integer.parseInt(br.readLine()),i;
    int arr[]=new int[N];
    for(i=0;i<N;i++)
    {
      arr[i]=Integer.parseInt(br.readLine());
    }
    System.out.print(solve(arr));
  }
}
