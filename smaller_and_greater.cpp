/*bookmark-filled
Smaller and Greater
You are given an Array A of size N.

Find for how many elements, there is a strictly smaller element and a strictly greater element.



Input Format

Given only argument A an Array of Integers.
Output Format

Return an Integer X, i.e number of elements.
Constraints

1 <= N <= 1e5
1 <= A[i] <= 1e6
For Example

Example Input:
    A = [1, 2, 3]

Example Output:
    1

Explanation:
    only 2 have a strictly smaller and strictly greater element, 1 and 3 respectively.*/
#include<bits/stdc++.h>
int min(int a,int b){
    if(a>b)
        return b;
    else
        return a;
}
int max(int a,int b){
    if(a<b)
        return b;
    else
        return a;
}
int main() {
    int A[]={391, 634, 740, 441, 75, 444, 65, 611, 679, 59, 878, 102, 42, 190, 801, 571, 79, 686, 523, 580, 199, 497, 879, 334, 200, 202, 991, 341, 479, 563, 112, 550, 494, 468, 56, 644, 53, 581, 836, 461, 905, 849, 838, 434, 818, 350, 585, 280, 252, 834, 510, 420, 395, 776, 118, 886, 19, 809, 534, 143, 933, 15, 999, 514, 230, 531, 666, 841, 861, 703, 972, 622, 640, 21, 811, 476, 751, 430, 308, 996, 165, 812, 424, 412, 903, 601, 226, 239, 728, 135};
    int ans = 0;
    // initialize the smallest and greatest element
    int mini = 1e9, maxi = -1e9;
    // find smallest and greatest element
    for(auto &i : A) {
        mini = min(mini, i);
        maxi = max(maxi, i);
    }
    // count the required elements
    for(auto &i : A) {
        if(mini < i and i < maxi)
            ans += 1;
    }
    // return the answer
    std::cout<<ans;
}