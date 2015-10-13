public class VerySecureEncryption{
  public String encrypt(String message, int[] key, int K){
		char[] current = message.toCharArray();
		char[] next = new char[message.length()];
		for(int times = 0; times < K; times++ ){
			for(int i = 0; i < key.length; i++ ){
				next[ key[i] ] = current[i];
			}
			System.arraycopy(next, 0, current, 0, next.length);
		}
		return String.valueOf(current);
	}
}
