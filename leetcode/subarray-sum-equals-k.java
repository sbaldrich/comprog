class Solution{
	public static int subarraySum(int[] nums, int k){
		int n = nums.length;
		int ans = 0;
		if( n == 0 ) return 0;
		int[] S = new int[n + 1];
		for(int i = 1; i <= n; i++)
			S[i] = nums[i - 1] + S[i - 1];
		Map<Integer, Integer> seen = new HashMap<>();
		for(int i = 0; i <= n; i++){
			ans += seen.getOrDefault(S[i], 0);
			seen.merge(S[i] + k, 1, Integer::sum);
		}
		return ans;
	}
}
