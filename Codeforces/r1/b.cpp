mport java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.*;

public class B {

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        int tests = Integer.parseInt(line);
        for(int i=0;i<tests;i++)
        {
            line = bf.readLine();
            if(line.matches("R[0-9]+C[0-9]+"))
            {
                String ans="",p[] = line.replaceAll("[R|C]", " ").trim().split(" ");
                Integer c = new Integer(p[1]);
                while(c>0)
                {
                    c--;
                    ans=(char)(c % 26 + 'A') + ans;
                    c/=26;
                }
                out.printf("%s%s\n",ans,p[0]);
            }
            else
            {
                String r = line.replaceAll("[A-Z]", ""), c = line.replaceAll("[0-9]", "");
                int num = 0;
                for(int j = 0 ; j < c.length() ; j++){
                    num = num * 26 +(c.charAt(j) - 'A'+1);
                }
                out.printf("R%sC%s\n",r,num);
            }
        }
        
    }

}
