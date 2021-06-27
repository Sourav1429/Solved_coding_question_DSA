/*Valid Sudoku
Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.



The input corresponding to the above configuration :

["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
A partially filled sudoku which is valid.

 Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
Return 0 / 1 ( 0 for false, 1 for true ) for this problem


×
*/
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int isValidSudoku(final String[] A) {
        HashMap<Character,Integer> hash=new HashMap<Character,Integer>();int l=A.length,m=A[0].length(),i,j,l1=0,l2=0,k=0;


        for(i=0;i<l;i++)
        {
            for(j=l1;j<l1+3;j++)
            {
                for(k=l2;k<l2+3;k++)
                {
                    if(A[j].charAt(k)=='.')
                    continue;
                else{
                    if(hash.get(A[j].charAt(k))!=null)
                        return 0;
                    else{
                        hash.put(A[j].charAt(k),1);
                    }
                }
            }
                    
                }
                //System.out.println(j+" "+k);
            if(k==l)
            {
                l2=0;
                l1+=3;
            }
            else{
                l2=k;
            }
            hash.clear();
            }
        for(i=0;i<l;i++)
        {
            for(j=0;j<m;j++)
            {
                if(A[i].charAt(j)=='.')
                    continue;
                else{
                    if(hash.get(A[i].charAt(j))!=null)
                        return 0;
                    else{
                        hash.put(A[i].charAt(j),1);
                    }
                }
            }
            hash.clear();
        }
        for(i=0;i<l;i++)
        {
            for(j=0;j<m;j++)
            {
                if(A[j].charAt(i)=='.')
                    continue;
                else{
                    if(hash.get(A[j].charAt(i))!=null)
                        return 0;
                    else{
                        hash.put(A[j].charAt(i),1);
                    }
                }
            }
            hash.clear();
        }
        return 1;
    }
}
