class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        int m = matrix.size(),n=matrix[0].size();
        vector<int> ans;
        int c=0,i,top=0,bottom=m-1,right=n-1,left=0;
        while(left<=right && top<=bottom)
        {
            for(i=left;i<=right;i++)
            {
                ans.push_back(matrix[top][i]);
                c++;
            }
            top++;
            if(c==m*n)
                break;
            for(i=top;i<=bottom;i++)
            {
                ans.push_back(matrix[i][right]);
                c++;
            }
            right--;
            if(c==m*n)
                break;
            if(left<=right)
            {
            for(i=right;i>=left;i--)
            {
                ans.push_back(matrix[bottom][i]);
                c++;
            }}
            bottom--;
            if(c==m*n)
                break;
            if(top<=bottom)
            {
            for(i=bottom;i>=top;i--)
            {
                ans.push_back(matrix[i][left]);
                c++;
            }}
            left++;
            if(c==m*n)
                break;
        }
        return ans;
    }
};
