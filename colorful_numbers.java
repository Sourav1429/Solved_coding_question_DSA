/*For Given Number N find if its COLORFUL number or not

Return 0/1

COLORFUL number:

A number can be broken into different contiguous sub-subsequence parts. 
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. 
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
Example:

N = 23
2 3 23
2 -> 2
3 -> 3
23 -> 6
this number is a COLORFUL number since product of every digit of a sub-sequence are different. 

Output : 1
*/
public class Solution {
    public int colorful(int A) {
        int i,n,size,k=0,l,val=0,rev=0;
        if(A%10==0)//If you have a zero at last then on reversing it will diappear. But if 0 is there multiplying with any value will give 0 only so it will be false
            return 0;
     for(i=A,n=0;i!=0;i/=10,n++)
        rev=rev*10+i%10;
     size=n*(n+1)/2;
     int arr[]=new int[size+1];
     arr[k++]=1;
     HashMap<Integer,Integer> hash=new HashMap<Integer,Integer>();
     for(i=rev,n=0;i!=0;i/=10,n++)
        {
            arr[k]=i%10;
            if(hash.get(arr[k])!=null)
                return 0;
            hash.put(arr[k++],1);
        }
        //System.out.println(arr[0]+" "+arr[1]+" "+arr[2]);
        l=k;
       // System.out.println(k);
     for(i=1;i<k-1;i++)
        {
            val=arr[i]*arr[i+1];
            //System.out.print(val);
            arr[l]=val;
            if(hash.get(val)!=null)
                return 0;
            hash.put(val,1);
            l+=1;
        }
     return 1;
    }
}
