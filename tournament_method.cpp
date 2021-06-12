#include<bits/stdc++.h>
int solve(std::vector<int> vect,int val)
{
    int l=vect.size(),i;std::vector<int> winner,looser;
    if(l==2 && val==1)
        return std::max(vect[0],vect[1]);
    else if(l==2 && val==0)
        return std::min(vect[0],vect[1]);
    /*for(i=0;i<l;i++)
        std::cout<<vect[i]<<'\n';*/
    for(i=0;i<l-1;i+=2)
    {
        if(vect[i]>vect[i+1])
            {winner.push_back(vect[i]);
            looser.push_back(vect[i+1]);}
        else{winner.push_back(vect[i+1]);
            looser.push_back(vect[i]);
        }

    }
    for(i=i;i<l;i++)
        winner.push_back(vect[i]);
    /*for(i=0;i<winner.size();i++)
        std::cout<<winner[i]<<'\t';*/
    if(val==0)
        return solve(looser,val);
    else if(val==1)
        return solve(winner,val);
}
int main()
{
    std::vector<int> vect{1,2,9,3,5,90,67,4,21,90},winner,looser;int min_max,i,l=vect.size();
    for(i=0;i<l-1;i+=2)
    {
        if(vect[i]>vect[i+1])
            {winner.push_back(vect[i]);
            looser.push_back(vect[i+1]);}
        else{winner.push_back(vect[i+1]);
            looser.push_back(vect[i]);
        }

    }
    for(i=i;i<l;i++)
        winner.push_back(vect[i]);
    int min=solve(looser,0);
    int max=solve(winner,1);
    std::cout<<min<<'\t'<<max;
}