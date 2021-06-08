/* hackerearth url: https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/special-shop-69904c91/
*/
#include<bits/stdc++.h>
#define cost(x,N,A,B) ((A)*(x)*(x))+((B)*((N-(x)))*((N-(x))))
int min(int a,int b)
{
    return a>b?b:a;
}
int solution(int N,int A,int B)
{
    float val=float(B*N)/(A+B);
    int x=int(val);
    if(val!=float(x))
    {
        return min(cost(x,N,A,B),cost(x+1,N,A,B));
    }
    else{
        return cost(x,N,A,B);
    }
}
int main()
{
    int T,N,A,B;
    std::cin>>T;
    for(int i=1;i<=T;i++)
    {
        std::cin>>N>>A>>B;
        std::cout<<solution(N,A,B);
    }

}