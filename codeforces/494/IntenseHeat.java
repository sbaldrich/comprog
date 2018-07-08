import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IntenseHeat {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arguments = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        int n = arguments[0], k = arguments[1];
        double[] a = Arrays.stream(reader.readLine().split("\\s+")).mapToDouble(Double::valueOf).toArray();
        double[] cumsum = new double[n + 1];
        System.arraycopy(a, 0, cumsum, 1, a.length);

        double ans = 0.0;

        for(int i = 1; i <= n; i++){
            cumsum[i] += cumsum[i-1];
        }

        for(int size = k; size <= n; size++){
            for(int i = 1; i + size -1 <= n; i++){
                double avg = (cumsum[i + size - 1] - cumsum[i - 1]) / size;
                ans = Math.max(ans, avg);
            }
        }

        System.out.println(ans);

    }
}

