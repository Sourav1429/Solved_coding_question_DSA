/* Find the reverse of a number. In case of overflow return 0*/
public class Solution {
    public long reverse(int A) {
        int negflag=0;
if(A<0)
{
negflag=1;
A = A*-1;
}
long ret=0;
while(A!=0)
{
ret = ret*10 + A%10;
A = A/10;
if(ret<Integer.MIN_VALUE || ret>Integer.MAX_VALUE)
{
ret=0;
break;
}
}
if(negflag==1) ret = ret*-1;

return ret;
    }
  public void main(String[] args)
  {
    System.out.print("Enter a number");
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    int n=Integer.parseInt(br.redLine());
    cout<<reverse(n);
  }
}
