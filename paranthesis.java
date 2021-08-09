import java.util.ArrayList;
class Solution{
    public void solve(char a,String A,ArrayList<String> vect,int B,int ans,int flag,String C)
    {
        if(flag==1)
        {
            if(a==')')
            {
                ans-=1;
                A=A+Character.toString(a);
            }
            else if(a=='(')
            {
                ans+=1;
                A=A+Character.toString(a);
            }
        }
        if(ans<0)
            return;
        if(B==0)
        {
            if(ans==0)
            {
                vect.add(A);
            }
            return;
        }
        for(int i=0;i<2;i++)
        {
            solve(C.charAt(i),A,vect,B-1,ans,1,C);
        }
    }
}
public class paranthesis {
    public static void main(String[] args) {
        int N=3,i;char a='0';String A="",C="()";
        ArrayList<String> vect=new ArrayList<String>();
        Solution s=new Solution();
        s.solve(a,A,vect,2*N,0,0,C);
        System.out.println(vect.size());
        for(i=0;i<vect.size();i++)
        {
            System.out.println(vect.get(i));
        }

    }
    
}
