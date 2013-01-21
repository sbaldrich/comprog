import java.util.Arrays;

public class NoisySensor {

	public int[] medianFilter(int[] data) {
		int n, ans[] = new int[n=data.length], aux[];
		ans[0] = data[0];
		ans[n-1] = data[n-1];
		for(int i=1;i<n-1;i++)
		{
			aux = new int[]{data[i-1] , data[i] , data[i+1]};
			Arrays.sort(aux);
			ans[i] = aux[1];
		}
		return ans;
	}

}
