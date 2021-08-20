'''Merge two sorted linked lists and return it as a new list. 

The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.

For example, given following linked lists :

  5 -> 8 -> 20 
  4 -> 11 -> 15
The merged list should be :

4 -> 5 -> 8 -> 11 -> 15 -> 20'''
# Definition for singly-linked list.
# class ListNode:
#	def __init__(self, x):
#		self.val = x
#		self.next = None

class Solution:
	# @param A : head node of linked list
	# @param B : head node of linked list
	# @return the head node in the linked list
	def mergeTwoLists(self, A, B):
        prev=None;head=None;present=0;
        while(A!=None and B !=None):
            if(A.val<B.val):
                present=A.val;
                A=A.next;
            else:
                present=B.val;
                B=B.next;
            node=ListNode(present);
            node.next=None;
            if(prev==None):
                head=node;
                prev=node;
            else:
                prev.next=node;
                prev=node;
        while(A!=None):
            node=ListNode(A.val);
            node.next=None;
            A=A.next;
            if(prev==None):
                head=node;
                prev=node;
            else:
                prev.next=node;
                prev=node;
        while(B!=None):
            node=ListNode(B.val);
            node.next=None;
            B=B.next;
            if(prev==None):
                head=node;
                prev=node;
            else:
                prev.next=node;
                prev=node;
        return head
