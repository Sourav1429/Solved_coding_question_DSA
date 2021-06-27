/*Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.

Example:

Input : [1, 0]
Return : [0, 1]
 Lets say N = size of the array. Then, following holds true :
All elements in the array are in the range [0, N-1]
N * N does not overflow for a signed integer*/

//https://www.quora.com/How-can-I-rearrange-a-given-array-so-that-Arr-I-becomes-Arr-Arr-I-with-O-1-extra-space
public class Solution {
	public void arrange(ArrayList<Integer> a) {
	    
	    for (int i = 0; i < a.size(); i++) {
	        
	        int index = a.get(i);
	        int val = a.get(index) % a.size() + 1;
	        a.set(i, a.get(i) + a.size() * val);
	    }
	    for (int i = 0; i < a.size(); i++) {
	        int val = a.get(i);
	        val = val / a.size() - 1;
    	    a.set(i, val);
	    }
	    
	}
}
