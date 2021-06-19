/*Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.

NOTE A solution will always exist. read Goldbach’s conjecture

Example:


Input : 4
Output: 2 + 2 = 4

If there are more than one solutions possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b,
and [c,d] is another solution with c <= d, then

[a, b] < [c, d] 

If a < c OR a==c AND b < d.*/
vector<int> primesum(int n) {
    vector<int> v;
bool a[n+1];
a[0] = a[1] = false;
for (int i=2; i<=n; i++)
a[i] = true;

for (int p=2; p*p<=n; p++)
{
        for (int i=p*p; i<=n; i += p)
            a[i] = false;
 
}
for (int i=0; i<n; i++)
{
    if (a[i] && a[n-i])
    {
        v.push_back(i);
        v.push_back(n-i);
        break;
    }
}
    
    return v;
}
