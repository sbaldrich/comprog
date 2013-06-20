public class ChatTranscript {

	public int howMany(String[] transcript, String name) {
		int n=0;
		for(String s : transcript)
			if(s.matches(name+":.*"))
				++n;
		return n;
	}

}
