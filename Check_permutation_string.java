/*Permutations of A in B
Problem Description

You are given two strings A and B of size N and M respectively.

You have to find the count of all permutations of A present in B as a substring. You can assume a string will have only lowercase letters.



Problem Constraints
1 <= N < M <= 105



Input Format
Given two argument, A and B of type String.



Output Format
Return a single Integer, i.e number of permutations of A present in B as a substring.



Example Input
Input 1:

 A = "abc"
 B = "abcbacabc"
Input 2:

 A = "aca"
 B = "acaa"


Example Output
Output 1:

 5
Output 2:

 2


Example Explanation
Explanation 1:

 Permutations of A that are present in B as substring are:
    1. abc
    2. cba
    3. bac
    4. cab
    5. abc
    So ans is 5.
Explanation 2:

 Permutations of A that are present in B as substring are:
    1. aca
    2. caa 
*/
//Their solution (taking 2 hasehs and finding if number of characters are equal or not.
public class Solution {
    public int solve(String A, String B) {
        int n = A.length();
        int m = B.length();
        int hash1[] = new int[26];
        int hash2[] = new int[26];
        int count = 0;
        // count frequency of each char in A 
        for (int i = 0; i < n; i += 1) {
            hash1[A.charAt(i) - 'a'] += 1;
        }
        // count frequency of each char in first window of size n in G
        for (int i = 0; i < n; i += 1) {
            hash2[B.charAt(i) - 'a'] += 1;
        }
        count += same(hash1, hash2);
        // move current window 1 step ahead
        for (int i = n, j = 0; i < m; i += 1, j += 1) {
            hash2[B.charAt(j) - 'a'] -= 1;
            hash2[B.charAt(i) - 'a'] += 1;
            count += same(hash1, hash2);
        }
        return count;
    }

    public int same(int[] hash1, int[] hash2) {
        for (int i = 0; i < 26; i += 1) {
            if (hash1[i] != hash2[i])
                return 0; // not a permutation of A
        }
        return 1; // got a permutation of A in G
    }
  public void main(String[] args)
  {
    String str1="abc";
    String str2="abcbcabcabcbaa";
    System.out.print(solve(str1,str2));
}
//My approach :  creating a hash function
/*
public class Solution {
    int power(int a,int b){
        b--;int p=a;
        while(b!=0)
        {
            p=p*a;
            b--;
        }
        return p;
    }
    public int solve(String A, String B) {
        int l1=A.length(),l2=B.length(),count=0,i;double val=0.0,ans=0.0;
        val=0.0;double sum=0;
        HashMap<Character,Double> hash=new HashMap<Character,Double>();char c;
        for(c='a',i=0;c<='z';c++,i++)
        {
            if(i%2==0)
                sum=sum+i/2;
            else
                sum=sum+i*i*i;
            hash.put(c,sum);
        }
        for(i=0;i<l1;i++)
        {
            val+=(hash.get(A.charAt(i)));
        }
        i=1;int k=0;
        while(i<=l2)
        {
          if(k==l1)
          {
              //System.out.print(ans+" ");
              if(ans==val)
              {
                  count+=1;
                  //System.out.print("ps:"+i+" ");
              }
              i-=l1;
              k=0;
              ans=0.0;
              //System.out.print("ps:"+i+" ");
          }
          else
          {
              ans+=(hash.get(B.charAt(i-1)));
              k+=1;
          }
          
          i+=1;
        }
        if(k==l1)
          {
              //System.out.print(ans+" ");
              if(ans==val)
              {
                  count+=1;
              }
              k=0;
              ans=0.0;
              //System.out.print("ps:"+i+" ");
          }
        //System.out.print(val);
        return count;
    }
}
*/
