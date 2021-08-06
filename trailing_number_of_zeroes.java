class Solution{
    public void solve(int A){
        int fi=0,i;
        for(i=A;i!=0;i/=5)
            fi+=i/5;
        System.out.println(fi);
    }
}
public class trailing_number_of_zeroes{
    public static void main(String[] args) {
        Solution s=new Solution();
        s.solve(6);
    }
}