public class ColumnDiagramPerimeter {

	public int getPerimiter(int[] a) {
		int n = a.length,ans = a[0] + a[n-1];
		for(int i=1;i<n;i++)
			ans+= Math.abs(a[i] - a[i-1]);
		return ans + 2*n;
	}

}
