import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MorganAndString {

     public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(reader.readLine());
        while (K --> 0) {
            char[] s = reader.readLine().toCharArray();
            char[] t = reader.readLine().toCharArray();
            char[] out = new char[s.length + t.length];
            int si = 0, ti = 0, oi = 0;
            while (si < s.length && ti < t.length) {
                if (s[si] < t[ti]) out[oi++] = s[si++];
                else if (s[si] > t[ti]) out[oi++] = t[ti++];
                else {
                    int p = si, q = ti;
                    char c = s[si];
                    for(; p < s.length && q < t.length; p++, q++) {
                        if (s[p] != t[q]) break;
                        else if (s[p] > c){
                            while(si < p) out[oi++] = s[si++];
                            while(ti < q) out[oi++] = t[ti++];
                            c = s[p];
                        }
                    }
                    if(p == s.length) out[oi++] = t[ti++];
                    else if(q == t.length) out[oi++] = s[si++];
                    else {
                        if (s[p] < t[q]) out[oi++] = s[si++];
                        else out[oi++] = t[ti++];
                    }
                }
            }
            while (si < s.length) out[oi++] = s[si++];
            while (ti < t.length) out[oi++] = t[ti++];
            System.out.println(new String(out));
        }
    }
}


