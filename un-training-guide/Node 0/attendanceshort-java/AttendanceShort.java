import java.util.ArrayList;

public class AttendanceShort {

	public String[] shortList(String[] names, String[] attendance) {
		ArrayList<String> ans = new ArrayList<String>();
		for(int i=0;i<names.length;i++)
		{
			char c[] = attendance[i].toCharArray();
			int abs = 0 , tot = c.length;
			for(char at : c)
				if(at == 'A')
					abs++;
				else if(at == 'M')
					tot--;
			if((tot-abs) < tot*0.75)
				ans.add(names[i]);
		}
		return ans.toArray(new String[ans.size()]);
	}

}
