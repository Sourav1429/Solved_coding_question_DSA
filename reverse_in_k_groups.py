'''Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
Example 3:

Input: head = [1,2,3,4,5], k = 1
Output: [1,2,3,4,5]
Example 4:

Input: head = [1], k = 1
Output: [1]
 

Constraints:

The number of nodes in the list is in the range sz.
1 <= sz <= 5000
0 <= Node.val <= 1000
1 <= k <= sz
 

Follow-up: Can you solve the problem in O(1) extra memory space?'''
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def length_(self,a):
        i=0;
        while(a!=None):
            i+=1;
            #print(type(a))
            a=a.next;
        return i;
    def reverseLL(self,head,end,prev):
        curr=head;beg=head;
        while(curr!=end):
            head=head.next;
            curr.next=prev;
            prev=curr;
            curr=head;
        beg.next=end;
        return prev;
    def reverseKGroup(self, a: ListNode, k: int) -> ListNode:
        i=0;l=self.length_(a);prev=None;beg=a;flag=0;ret_val=None;
        while(i<l):
            i+=1;
            if(i%k==0):
                #print(i,"#sourav%");
                end=a.next;
                #traverse(end);print("0k");
                head=self.reverseLL(beg,end,prev);
                if(flag==0):
                    ret_val=head;
                    flag=1;
                else:
                    prev.next=head;
                prev=beg;
                beg=end;
                a=prev;
            a=a.next;
        return ret_val;
