import java.io.*;
public class excel_column_title_from_number {
    public static int solve(String a)
    {
        int l=a.length(),val=0,p=1,i;
        for(i=l-1;i>=0;i--)
        {
            val=val+(int)(a.charAt(i)-64)*p;
            p=p*26;
        }
        return val;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        System.out.println(solve(str));
    }
    
}
