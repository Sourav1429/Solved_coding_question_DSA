/*Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
Example 4:

Input: s = "([)]"
Output: false
Example 5:

Input: s = "{[]}"
Output: true
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'*/
class Solution {
    public boolean isValid(String s) {
        char a,b;
        int l=s.length(),i;Stack<Character> stk=new Stack<Character>();
        for(i=0;i<l;i++)
        {
            a=s.charAt(i);
            if(a==')'||a=='}'||a==']')
            {
                if(stk.empty())
                    return false;
                b=stk.pop();
                if(a==')' && b!='(')
                    return false;
                else if(a=='}'&& b!='{')
                    return false;
                else if(a==']'&&b!='[')
                    return false;
            }
            else
                stk.push(a);
        }
        return stk.empty();
    }
}
