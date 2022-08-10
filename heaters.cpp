/*Winter is coming! During the contest, your first job is to design a standard heater with a fixed warm radius to warm all the houses.

Every house can be warmed, as long as the house is within the heater's warm radius range. 

Given the positions of houses and heaters on a horizontal line, return the minimum radius standard of heaters so that those heaters could cover all houses.

Notice that all the heaters follow your radius standard, and the warm radius will the same.

 

Example 1:

Input: houses = [1,2,3], heaters = [2]
Output: 1
Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
Example 2:

Input: houses = [1,2,3,4], heaters = [1,4]
Output: 1
Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.
Example 3:

Input: houses = [1,5], heaters = [2]
Output: 3
 

Constraints:

1 <= houses.length, heaters.length <= 3 * 104
1 <= houses[i], heaters[i] <= 109*/
class Solution {
public:
    int search(vector<int>& h, int l, int r, int k)
    {
        if(l>=r) return l;
        int mid = l+(r-l)/2;
        if(abs(h[mid]-k)>abs(h[mid+1]-k))
            return search(h, mid+1, r, k);
        else
            return search(h, l, mid, k);
    }
    int findRadius(vector<int>& houses, vector<int>& heaters) {
        //remove duplicates from heaters
        set<int> st(heaters.begin(), heaters.end());
        vector<int> hts(st.begin(), st.end());
        //sort
        sort(hts.begin(), hts.end());
        //binary search
        int l=0, r=hts.size()-1, maxVal = -1;
        for(int i=0; i<houses.size(); i++)
        {
            int id = search(hts, l, r, houses[i]);
            maxVal = max(maxVal, abs(houses[i]-hts[id]));
        }
        return maxVal;
    }
};
