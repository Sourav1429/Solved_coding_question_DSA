/*Maximum Frequency stack
Problem Description

You are given a matrix A which represent operations of size N x 2. Assume initially you have a stack-like data structure you have to perform operations on it.

Operations are of two types:

1 x: push an integer x onto the stack and return -1

2 0: remove and return the most frequent element in the stack.

If there is a tie for the most frequent element, the element closest to the top of the stack is removed and returned.

A[i][0] describes the type of operation to be performed. A[i][1] describe the element x or 0 corresponding to the operation performed.



Problem Constraints
1 <= N <= 100000

1 <= A[i][0] <= 2

0 <= A[i][1] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return the array of integers denoting answer to each operation.



Example Input
Input 1:

A = [
            [1, 5]
            [1, 7]
            [1, 5]
            [1, 7]
            [1, 4]
            [1, 5]
            [2, 0]
            [2, 0]
            [2, 0]
            [2, 0]  ]
Input 2:

 A =  [   
        [1, 5]
        [2 0]
        [1 4]   ]


Example Output
Output 1:

 [-1, -1, -1, -1, -1, -1, 5, 7, 5, 4]
Output 2:

 [-1, 5, -1]


Example Explanation
Explanation 1:

 Just simulate given operations
Explanation 2:

 Just simulate given operations*/
unordered_map < int, int > freq; // to store frequence of an element in the stack.
unordered_map < int, stack < int >> stacks; // to maintain the structure of stack and pop out top most element in case of a tie. 

int max_freq = 0;
void push(int x) {
  freq[x]++;
  if (freq[x] > max_freq) max_freq = freq[x];

  if (stacks.count(freq[x])) {
    stacks[freq[x]].push(x);
  } else {
    stack < int > st;
    st.push(x);
    stacks[freq[x]] = st;
  }

}

int pop() {
  int x = stacks[max_freq].top();
  stacks[max_freq].pop();

  freq[x]--;
  if (stacks[max_freq].empty()) {
    max_freq--;
  }

  return x;
}
vector < int > Solution::solve(vector < vector < int > > & A) {

  // clear global variables
  max_freq = 0;
  freq.clear();

  stacks.clear();
  vector < int > ans;
  for (int i = 0; i < A.size(); i++) {
    if (A[i][0] == 1) {
      push(A[i][1]);
      ans.push_back(-1);
    } else {
      int x = pop();
      ans.push_back(x);
    }
  }

  return ans;
}
