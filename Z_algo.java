class Solution{
    public void solve(String s)
    {
        int L=0,R=0,N=s.length(),i,j;
        int Z[]=new int[N];
        Z[0]=N;
        for(i=1;i<N;i++)
        {
            if(i>R)
            {
                L=i;R=i;
                while(R<N)
                {
                    if(s.charAt(R)!=s.charAt(R-L))
                        break;
                    R+=1;
                }
                Z[L]=R-L;
                R-=1;
            }
            else
            {
                j=i-L;
                if(Z[j]<R-i+1){
                    Z[i]=Z[j];
                }
                else{
                    L=i;
                    R++;
                    while(R<N && s.charAt(R-L)==s.charAt(R))
                    {
                        R+=1;
                    }
                    Z[i]=R-L;
                    R-=1;
                }
            }
        }
        for(i=0;i<N;i++)
        {
            System.out.print(Z[i]+"--->");
        }
    }
}
public class Z_algo{
    public static void main(String[] args) {
        String str="xxyxxyxxaxxyxxz";
       Solution s=new Solution();
       s.solve(str); 
    }
}