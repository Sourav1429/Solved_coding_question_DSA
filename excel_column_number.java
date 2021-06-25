import java.io.*;
public class excel_column_number {
    public static String convertToTitle(int A) {
        int d,L=0;
        StringBuilder str=new StringBuilder("");
        char bow[]={'Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y'};
        while(A>0)
        {
            d=A%26;
            if(d==0)
                A=(A/26)-1;
            else
                A=A/26;
            str=str.append(bow[d]);
            L+=1;
        }
        str.reverse();
        return str.toString();
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int A=Integer.parseInt(br.readLine());
        System.out.println(convertToTitle(A));   
    }
    
}
