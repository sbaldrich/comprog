public class NetworkXZeroOne {

	public String reconstruct(String message) {
		char c[] = message.toCharArray();
		int n = c.length;
		for (int i = 0; i < n; i++) {
			boolean x = false;
			if (c[i] == 'o') {
				x = true;
				for (int j = i + 1; j < n; j++) {
					c[j] = x ? 'x' : 'o';
					x = !x;
				}
				x = true;
				for (int j = i - 1; j >= 0; j--) {
					c[j] = x ? 'x' : 'o';
					x = !x;
				}
				return new String(c);
			}
			else if (c[i] == 'x')
			{
				x = false;
				for (int j = i + 1; j < n; j++) {
					c[j] = x ? 'x' : 'o';
					x = !x;
				}
				x = false;
				for (int j = i - 1; j >= 0; j--) {
					c[j] = x ? 'x' : 'o';
					x = !x;
				}
				return new String(c);
			}

		}
		return "shit, you shouldn't be here";
	}

}
