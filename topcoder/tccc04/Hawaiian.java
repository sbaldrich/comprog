import java.util.*;

public class Hawaiian{
	public boolean hawaii( String word ){
		String valid = "aeiouhklmnpw";
		char chr[]= word.toLowerCase().toCharArray();
		for( char c : chr )
			if(valid.indexOf(c) == -1)
				return false;
		return true;
	}

	public String[] getWords(String sentence){
		String words[] = sentence.split("\\s+");
		List<String> hawaiian = new ArrayList<>();
		for(String word : words){
			if(hawaii(word))
				hawaiian.add(word);
		}
		return hawaiian.toArray(new String[hawaiian.size()]);
	}
}
