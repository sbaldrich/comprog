public class DivToZero {

	public String lastTwo(int num, int factor) {
		num/=100;
		num*=100;
		for(;num%factor!=0;num++);
		String ans = "";
		ans += num%10;
		num/=10;
		ans += num%10;
		return "" + ans.charAt(1) + ans.charAt(0);
		
		
		
	}

}
