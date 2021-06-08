/*Min Steps in Infinite Grid
Problem Description

You are in an infinite 2D grid where you can move in any of the 8 directions

 (x,y) to 
    (x+1, y), 
    (x - 1, y), 
    (x, y+1), 
    (x, y-1), 
    (x-1, y-1), 
    (x+1,y+1), 
    (x-1,y+1), 
    (x+1,y-1) 
You are given a sequence of points and the order in which you need to cover the points.. Give the minimum number of steps in which you can achieve it. You start from the first point.

NOTE: This question is intentionally left slightly vague. Clarify the question by trying out a few cases in the “See Expected Output” section.



Input Format
Given two integer arrays A and B, where A[i] is x coordinate and B[i] is y coordinate of ith point respectively.



Output Format
Return an Integer, i.e minimum number of steps.



Example Input
Input 1:

 A = [0, 1, 1]
 B = [0, 1, 2]


Example Output
Output 1:

 2


Example Explanation
Explanation 1:

 Given three points are: (0, 0), (1, 1) and (1, 2).
 It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).
*/
int abso(int a)
{
    return a<0?-a:a;
}
int min(int a, int b)
{
    return a<b?a:b;
}
int coverPoints(vector<int> &A, vector<int> &B) {
    int l1=A.size(),l2=B.size(),count=0,dif_x,dif_y,sign_x,sign_y,i,step;
    if(l1!=l2)
        return -1;
    int present_x=A[0],present_y=B[0];
    for(i=1;i<l1;i++)
    {
        dif_x=A[i]-present_x;
        dif_y=B[i]-present_y;
        sign_x=dif_x<0?1:0;
        sign_y=dif_y<0?1:0;
        dif_x=abso(dif_x);
        dif_y=abso(dif_y);
        if(sign_x && sign_y)
        {
            if(dif_x && dif_y)
            {
                step=min(dif_x,dif_y);
                present_x-=step;
                present_y-=step;
                dif_x-=step;
                dif_y-=step;
                count+=step;
            }
            if(dif_x)
            {
                count+=dif_x;
                present_x-=dif_x;
                dif_x=0;
            }
            if(dif_y)
            {
                count+=dif_y;
                present_y-=dif_y;
                dif_y=0;
            }
        }
        else if(sign_y)
        {
            if(dif_x && dif_y)
            {
                step=min(dif_x,dif_y);
                present_x+=step;
                present_y-=step;
                dif_x-=step;
                dif_y-=step;
                count+=step;
            }
            if(dif_x)
            {
                count+=dif_x;
                present_x+=dif_x;
                dif_x=0;
            }
            if(dif_y)
            {
                count+=dif_y;
                present_y-=dif_y;
                dif_y=0;
            }
        }
        else if(sign_x)
        {
            if(dif_x && dif_y)
            {
                step=min(dif_x,dif_y);
                present_x-=step;
                present_y+=step;
                dif_x-=step;
                dif_y-=step;
                count+=step;
            }
            if(dif_x)
            {
                count+=dif_x;
                present_x-=dif_x;
                dif_x=0;
            }
            if(dif_y)
            {
                count+=dif_y;
                present_y+=dif_y;
                dif_y=0;
            }
        }
        else if(sign_x==0 and sign_y==0)
        {
            if(dif_x && dif_y)
            {
                step=min(dif_x,dif_y);
                present_x+=step;
                present_y+=step;
                dif_x-=step;
                dif_y-=step;
                count+=step;
            }
            if(dif_x)
            {
                count+=dif_x;
                present_x+=dif_x;
                dif_x=0;
            }
            if(dif_y)
            {
                count+=dif_y;
                present_y+=dif_y;
                dif_y=0;
            }
        }
    }
    return count;
}
int main()
{
    vector<int> A{0,5,6};
    vector<int> B{1,2,7};
    std::cout<<coverPoints(A,B);
}