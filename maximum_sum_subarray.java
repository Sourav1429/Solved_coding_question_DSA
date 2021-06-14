/* The aim here is to find the subarray having the maximum sum value along with the index positions of the array
*/
public class Solution {
    public int[] solve(int[] A, int B) {
        int l=A.length,i,sum=0,sum2=Integer.MIN_VALUE,flag=1,init_i=-1,final_i=-1;
        for(i=0;i<l;i++)
        {
            sum+=A[i];
            if(sum>sum2){
                sum2=sum;
                if(flag==1)
                    {init_i=i;flag=0;}
                final_i=i;
            }
            if(sum<0)
            {
                sum=0;
                flag=1;
            }
        }
        System.out.print(sum2+" "+init_i+" "+final_i);
        int arr[]=new int[0];
        return arr;
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
