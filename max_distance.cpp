/*Given an array A of integers of size N. Find the maximum of value of j - i such that A[i] <= A[j].



Problem Constraints

1 <= N <= 1000000

-109 <= A[i] <= 109



Input Format

First argument is an integer array A of size N.



Output Format

Return an integer denoting the maximum value of j - i.



Example Input

Input 1:

A = [3, 5, 4, 2]


Example Output

Output 1:

2


Example Explanation

Explanation 1:

For A[0] = 3 and A[2] = 4, the ans is (2 - 0) = 2. 
*/
void sorting(std::vector<std::pair<int,int>> &a,int l,int u)
{
    int pivot=a[u-1].first,pos=l-1,i;std::pair<int,int> pa,pivel=a[u];
    if(l>=u)
        return;

    for(i=l;i<u-1;i++)
    {
        if(a[i].first<=pivot)
        {
            pa=a[pos+1];
            a[pos+1]=a[i];
            a[i]=pa;
            pos+=1;
        }
    }
    pa=a[pos+1];
    a[pos+1]=a[i];
    a[i]=pa;
    pos+=1;
    sorting(a,l,pos);
    sorting(a,pos+1,u);
}
int Solution::maximumGap(const vector<int> &num) {
    if (num.size() == 0) 
                return -1;
            if (num.size() == 1) 
                return 0;
            vector<pair<int, int> > toSort; 
            for (int i = 0; i < num.size(); i++) {
                toSort.push_back(make_pair(num[i], i));
            }
            sort(toSort.begin(), toSort.end());
            int len = toSort.size();
            int maxIndex = toSort[len - 1].second;
            int ans = 0;
            for (int i = len - 2; i >= 0; i--) {
                ans = max(ans, maxIndex - toSort[i].second);
                maxIndex = max(maxIndex, toSort[i].second);
            }
            return ans;}
