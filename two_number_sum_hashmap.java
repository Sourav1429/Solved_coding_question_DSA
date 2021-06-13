/* 2 Sum
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 < index2. Please note that your returned answers (both index1 and index2 ) are not zero-based. Put both these numbers in order in an array and return the array from your function ( Looking at the function signature will make things clearer ). Note that, if no pair exists, return empty list.

If multiple solutions exist, output the one where index2 is minimum. If there are multiple solutions with the minimum index2, choose the one with minimum index1 out of them.

Input: [2, 7, 11, 15], target=9
Output: index1 = 1, index2 = 2

Some edge cases encountered:
input [-2,0,-1,5,-1],target=-2
input [-10,-10,-10], target=-5
input [4,-2,6,7,3,4,-1],target=-2
*/
//MY SOLUTION
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] twoSum(final int[] A, int B) {
        HashMap<Integer,Integer> hash=new HashMap<>();
        int i,init_i,final_i,indexi=-1,mini=0,a,l=A.length;int arr[]=new int[2];int flag=1;
        for(i=0;i<l;i++)
        {
            if(hash.get(B-A[i])==null)
                hash.put(B-A[i],i+1);
                //Section to avoid duplicates
            else if(A[i]*2==B)
            {
                if(mini==0)
               {
                   flag=0;
                   indexi=hash.get(B-A[i]);
               mini=i+1;
               }
               
            }
        }
        for(i=0;i<l;i++)
        {
            if((hash.get(A[i])==null))
                continue;
            a=hash.get(A[i]);
            if(a>0)
            {
                init_i=(a>i+1)?i+1:a;
                final_i=(a<i+1)?i+1:a;
                if((flag==1) || ((mini>final_i)&&(init_i!=final_i)))
                {
                    flag=0;
                    indexi=init_i;
                    mini=final_i;
                    
                }
                
            }
        }
        if(indexi==-1)
            {int arr2[] = new int[0];
return arr2;}
        arr[0]=indexi;
        arr[1]=mini;
        return arr;
    }
public void main(String[] args)
{
    int arr[]={};
    int target=;
    int arr2[]=new int[2];
    arr2=twoSum(arr,target);
    System.out.print(arr2[0]+" "+arr2[1]);
}
}
/* Solved solution */
//JAVA
/*
public class Solution {
    
    static class Node implements Comparable<Node> {
        
        int left;
        int right;
        
        public Node(int left, int right) {
            this.left = left;
            this.right  = right;
        }
        
        public int compareTo(Node o) {
            if (this.right < o.right)
                return -1;
            if (this.right > o.right)
                return 1;
                
            return Integer.compare(this.left, o.left);
        }
        
    }
    
	public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
	    
	    int sum = B;
	    int diff;
	    HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
	    int size = A.size();
	    int num;
	    int index;
	    ArrayList<Integer> res = new ArrayList<Integer>();
        ArrayList<Node> node = new ArrayList<>();
	    
	    for (int i = size - 1; i >= 0; i--) {
	        num = A.get(i);
	        diff = sum - num;
	        
	        if (hashMap.containsKey(diff)) {
	            index = hashMap.get(diff);
	            node.add(new Node(i + 1, index + 1));
	        }
	        
	        hashMap.put(num, i);
	        
	    }
	    
	    if (node.size() > 0) {
	        Collections.sort(node);
            res.add(node.get(0).left);
            res.add(node.get(0).right);
	    }
	    
	    return res;
	    
	}
}
*/
//CPP
/*
class Solution {
    public:
        vector<int> twoSum(const vector<int> &num, int target) {
                
            // map to store the mapping from number to its index. 
                        map<int, int> M;
            vector<int> ans;

            for (int i = 0; i < num.size(); i++) {
                int required = target - num[i];
                if (M.find(required) != M.end()) {
                    // We have our solution. index1 = M[required], index2 = i + 1 ( 1 based ). 
                    ans.push_back(M[required]);
                    ans.push_back(i + 1);
                    return ans;
                }
                if (M.find(num[i]) == M.end()) {
                    // We want to maintain the minimum index at M[num[i]]. i + 1 will 
                    // obviously be greater than whats already present.
                    M[num[i]] = i + 1;
                }
            }
            return ans;
        }
};
*/
//PYTHON
/*
class Solution:
    # @param A : tuple of integers
    # @param B : integer
    # @return a list of integers
    def twoSum(self, A, B):
        hashDict = dict()
        n = len(A)
        for i in range(n):
            if A[i] in hashDict:
                return [hashDict[A[i]]+1,i+1]
            elif B-A[i] not in hashDict:
                hashDict[B-A[i]]=i
        return []
*/