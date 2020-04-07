public class MagicSpell {

	public String fixTheSpell(String spell) {
		StringBuffer sb = new StringBuffer(spell.replaceAll("[B-Y]" , ""));
		sb.reverse();
		char o[] = spell.toCharArray();
		for(int i=0,j=0;i<o.length;i++)
		{
			if(o[i] == 'A' || o[i]=='Z')
				o[i] = sb.charAt(j++);
		}
		return new String(o);
	}

}
