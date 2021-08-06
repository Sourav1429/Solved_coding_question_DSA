class Solution{
    public void solve(int A[])
    {
        int l=A.length,i,start=0;
        /*if(l==1 && A[0]<0)
            return new int[0];*/
        int m_end=0,m_start=0,nos=1,mnos=1;long sum=0l,max=A[0];
        for(i=0;i<l;i++)
        {
            if(A[i]<0)
            {
                if(sum==max)
                    {
                        if(nos>mnos)
                        {
                            max=sum;
                            m_start=start;
                            m_end=i-1;
                            mnos=nos;
                        }
                    }
                else if(sum>max)
                {
                    max=sum;
                    m_start=start;
                    m_end=i-1;
                    mnos=nos; 
                }
                sum=0;
                start=i+1;
                nos=0;
            }
            else
            {
                sum+=A[i];
                nos+=1;
            }
        }
        if(sum>max)
        {
            max=sum;
            m_start=start;
            m_end=i-1;
        }
        else if(sum==max)
        {
            if(nos>mnos)
            {
                max=sum;
                m_start=start;
                m_end=i-1;
                mnos=nos;
            }  
        }
        int arr[]=new int[m_end-m_start+1];
        for(i=m_start;i<=m_end;i++)
            arr[i-m_start]=A[i];
        l=m_end-m_start+1;
        System.out.println(m_start+" "+m_end);
        for(i=0;i<l;i++)
            System.out.print(arr[i]+" ");
        //System.out.println(max);
    }
}
public class max_no_neg_subarray {
    public static void main(String[] args) {
        int A[]={-7,-8,9,-10};
        Solution s=new Solution();
        s.solve(A);
    }
    
}
