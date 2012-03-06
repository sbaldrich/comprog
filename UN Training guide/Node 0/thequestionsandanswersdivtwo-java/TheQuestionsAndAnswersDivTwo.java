import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TheQuestionsAndAnswersDivTwo {

	public int find(String[] questions) {
		Set<String> q = new HashSet<String>(Arrays.asList(questions));
		return (int)Math.pow(2, q.size());
	}

}
