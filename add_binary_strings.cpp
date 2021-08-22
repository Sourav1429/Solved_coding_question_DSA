/*Problem Description

Given two binary strings, return their sum (also a binary string).
Example:

a = "100"


b = "11"
Return a + b = "111".*/
string Solution::addBinary(string A, string B) {
    int l1=A.size(),l2=B.size(),c=0,i,a,b;char t;
    for(i=0;i<l1/2;i++)
    {
        t=A[i];
        A[i]=A[l1-i-1];
        A[l1-i-1]=t;
    }
    //cout<<A<<'\n';
    for(i=0;i<l2/2;i++)
    {
        t=B[i];
        B[i]=B[l2-i-1];
        B[l2-i-1]=t;
    }
    //cout<<B<<'\n';
    i=0;
    while(i<l1 && i<l2)
    {
        a=A[i]-48;b=B[i]-48;
        A[i]=(char)((a^b^c)+48);
        c=(a&b)|(a&c)|(b&c);
        i+=1;
    }
    //cout<<A<<'\n';
    while(i<l1)
    {
        a=A[i]-48;
        A[i]=(char)((a^c)+48);
        c=(a&c);
        i+=1;
    }
    while(i<l2)
    {
        b=B[i]-48;
        A=A+to_string(b^c);
        c=(b&c);
        i+=1;
    }
    if(c>0)
        {A=A+to_string(c);i+=1;}
    for(l1=0;l1<i/2;l1++)
    {
        t=A[l1];
        A[l1]=A[i-l1-1];
        A[i-l1-1]=t;
    }
    return A;
}
