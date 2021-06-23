/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example:

Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
*/
class Solution {
    public:
        static bool compareNum(string a, string b) {
            return a + b > b + a;
        }

        string largestNumber(const vector<int> &num) {
            string result;
            vector<string> str;
            for (int i = 0; i < num.size(); i++) {
                str.push_back(to_string(num[i]));
            }
            sort(str.begin(), str.end(), compareNum);
            for (int i = 0; i < str.size(); i++) {
                result += str[i];
            }

            int pos = 0;
            while (result[pos] == '0' && pos + 1 < result.size()) pos++; 
            return result.substr(pos);
        }
};
//JAVA CODE
/*
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public String largestNumber(final int[] A) {
        
         String[] arr = new String[A.length];
    for(int i=0; i<A.length; i++){
        arr[i]=String.valueOf(A[i]);
    }
 
    Arrays.sort(arr, new Comparator<String>(){
        public int compare(String a, String b){
            return (b+a).compareTo(a+b);
        }
    });
 
    StringBuilder sb = new StringBuilder();
    for(String s: arr){
        sb.append(s);
    }
 
    while(sb.charAt(0)=='0'&&sb.length()>1)
        sb.deleteCharAt(0);
 
    return sb.toString();

    }
}
*/
