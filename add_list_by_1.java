class LinkedList{
    int x;
    LinkedList next;
    public LinkedList(int v)
    {
        x=v;
        next=null;
    }
}
class Solution{
    public LinkedList reverse(LinkedList head)
    {
        LinkedList head2=null,node=null;
        while(head!=null)
        {
            node=new LinkedList(head.x);
            head=head.next;
            if(head2==null)
            {
                head2=node;
            }
            else{
               node.next=head2;
                head2=node;
            }
        }
        return head2;
    }
    public void solve(LinkedList head)
    {
        LinkedList head2=null,prev=null,node=null;
        head2=reverse(head);
        prev=head2;int c=1;
        while(prev!=null)
        {
            System.out.print(prev.x+"->");
            prev=prev.next;
        }
        System.out.println("break down here\n=============");
        prev=head2;
        while(head2!=null)
        {
            head2.x=head2.x+c;
            c=head2.x/10;
            head2.x=head2.x%10;
            head2=head2.next;
        }
        head=reverse(prev);
        if(c>0)
        {
            node=new LinkedList(c);
            node.next=head;
            head=node;
        }
        while(head!=null)
        {
            System.out.print(head.x+"->");
            head=head.next;
        }
    }
}
public class add_list_by_1{
    public static LinkedList insert(int A[])
    {
        int l=A.length,i;LinkedList head=null,node=null,prev=null;
        for(i=0;i<l;i++)
        {
            node=new LinkedList(A[i]);
            if(head==null)
            {
                head=node;
                prev=node;
            }
            else{
                prev.next=node;
                prev=node;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        int A[]={9,8,9,9};
        LinkedList head=insert(A);
        LinkedList h=head;
        Solution s=new Solution();
        s.solve(h);
    }
}